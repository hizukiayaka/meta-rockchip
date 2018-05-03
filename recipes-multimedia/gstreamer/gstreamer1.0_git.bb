# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)
DEFAULT_PREFERENCE = "-1"

SUMMARY = "GStreamer 1.0 multimedia framework"
DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
LICENSE = "LGPLv2+"

DEPENDS = "glib-2.0 glib-2.0-native libcap libxml2 bison-native flex-native"

inherit autotools pkgconfig gettext upstream-version-is-even gobject-introspection gtk-doc

# This way common/m4/introspection.m4 will come first
# (it has a custom INTROSPECTION_INIT macro, and so must be used instead of our common introspection.m4 file)
acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://git.sumomo.pri/gstreamer/gstreamer.git;protocol=ssh;branch=master;name=base \
    git://git.sumomo.pri/gstreamer/common.git;destsuffix=git/common;protocol=ssh;branch=master;name=common \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://gtk-doc-tweaks.patch \
    file://0001-gst-gstpluginloader.c-when-env-var-is-set-do-not-fal.patch \
"

SRCREV_FORMAT = "base"
SRCREV = "${AUTOREV}"

do_configure_prepend() {
        ${S}/autogen.sh --noconfigure
}

PACKAGECONFIG ??= "${@bb.utils.contains('PTEST_ENABLED', '1', 'tests', '', d)} \
	           "

PACKAGECONFIG[debug] = "--enable-debug,--disable-debug"
PACKAGECONFIG[tests] = "--enable-tests,--disable-tests"
PACKAGECONFIG[valgrind] = "--enable-valgrind,--disable-valgrind,valgrind,"
PACKAGECONFIG[gst-tracer-hooks] = "--enable-gst-tracer-hooks,--disable-gst-tracer-hooks,"
PACKAGECONFIG[unwind] = "--with-unwind,--without-unwind,libunwind"
PACKAGECONFIG[dw] = "--with-dw,--without-dw,elfutils"

EXTRA_OECONF = " \
    --disable-examples \
"

EXTRA_OECONF_remove = "--disable-gtk-doc"

CACHED_CONFIGUREVARS += "ac_cv_header_valgrind_valgrind_h=no"

# musl libc generates warnings if <sys/poll.h> is included directly
CACHED_CONFIGUREVARS += "ac_cv_header_sys_poll_h=no"

PACKAGES += "${PN}-bash-completion"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la ${libdir}/gstreamer-1.0/*.a ${libdir}/gstreamer-1.0/include"
FILES_${PN}-bash-completion += "${datadir}/bash-completion/completions/ ${datadir}/bash-completion/helpers/gst*"
FILES_${PN}-dbg += "${datadir}/gdb ${datadir}/gstreamer-1.0/gdb"

RDEPENDS_${PN}-ptest += "make"

delete_pkg_m4_file() {
        # This m4 file is out of date and is missing PKG_CONFIG_SYSROOT_PATH tweaks which we need for introspection
        rm "${S}/common/m4/pkg.m4" || true
        rm -f "${S}/common/m4/gtk-doc.m4"
}

do_configure[prefuncs] += "delete_pkg_m4_file"

do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/gst/.libs:${B}/libs/gst/base/.libs"
}

do_compile_ptest() {
	oe_runmake build-checks
}

do_install_ptest() {
        oe_runmake -C tests/check DESTDIR=${D}${PTEST_PATH} install-ptest
        install -m 644 ${B}/tests/check/Makefile ${D}${PTEST_PATH}
        install -m 755 ${S}/test-driver ${D}${PTEST_PATH}
        sed -e 's,--sysroot=${STAGING_DIR_TARGET},,g' \
            -e 's|${DEBUG_PREFIX_MAP}||g' \
            -e 's:${HOSTTOOLS_DIR}/::g' \
            -e 's:${RECIPE_SYSROOT_NATIVE}::g' \
            -e 's:${BASE_WORKDIR}/${MULTIMACH_TARGET_SYS}::g' \-e 's/^Makefile:/_Makefile:/' \
            -e 's/^srcdir = \(.*\)/srcdir = ./' -e 's/^top_srcdir = \(.*\)/top_srcdir = ./' \
            -e 's/^builddir = \(.*\)/builddir = ./' -e 's/^top_builddir = \(.*\)/top_builddir = ./' \
            -i ${D}${PTEST_PATH}/Makefile
}

CVE_PRODUCT = "gstreamer"

FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/${PN}:"
FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
FILESPATH_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/${PN}:"
FILESPATH_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
