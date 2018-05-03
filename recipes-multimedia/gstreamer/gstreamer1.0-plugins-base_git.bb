# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)
DEFAULT_PREFERENCE = "-1"

require recipes-multimedia/gstreamer/gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://git.sumomo.pri/gstreamer/gst-plugins-base.git;protocol=ssh;branch=master;name=base \
    git://git.sumomo.pri/gstreamer/common.git;destsuffix=git/common;protocol=ssh;branch=master;name=common \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://0001-Makefile.am-prefix-calls-to-pkg-config-with-PKG_CONF.patch \
    file://0002-riff-add-missing-include-directories-when-calling-in.patch \
    file://0003-rtsp-drop-incorrect-reference-to-gstreamer-sdp-in-Ma.patch \
    file://0004-glimagesink-Downrank-to-marginal.patch \
"

SRCREV_FORMAT = "git"
SRCREV = "${AUTOREV}"

DEPENDS += "iso-codes util-linux"

inherit gettext gobject-introspection

PACKAGES_DYNAMIC =+ "^libgst.*"

PACKAGECONFIG_GL ?= "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"

PACKAGECONFIG ??= " \
    ${GSTREAMER_ORC} \
    ${PACKAGECONFIG_GL} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'alsa x11', d)} \
    gio-unix-2.0 ogg pango theora vorbis zlib jpeg \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland egl', '', d)} \
    gbm \
"

X11DEPENDS = "virtual/libx11 libsm libxrender libxv"
X11ENABLEOPTS = "--enable-x --enable-xvideo --enable-xshm"
X11DISABLEOPTS = "--disable-x --disable-xvideo --disable-xshm"

PACKAGECONFIG[alsa]         = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[cdparanoia]   = "--enable-cdparanoia,--disable-cdparanoia,cdparanoia"
PACKAGECONFIG[egl]          = "--enable-egl,--disable-egl,virtual/egl"
PACKAGECONFIG[gbm]          = "--enable-gbm,--disable-gbm,virtual/libgbm libgudev libdrm"
PACKAGECONFIG[gio-unix-2.0] = ",--disable-gio,glib-2.0"
PACKAGECONFIG[gles2]        = "--enable-gles2,--disable-gles2,virtual/libgles2"
PACKAGECONFIG[ivorbis]      = "--enable-ivorbis,--disable-ivorbis,tremor"
PACKAGECONFIG[jpeg]         = "--enable-jpeg,--disable-jpeg,jpeg"
PACKAGECONFIG[ogg]          = "--enable-ogg,--disable-ogg,libogg"
PACKAGECONFIG[opengl]       = "--enable-opengl,--disable-opengl,virtual/libgl libglu"
PACKAGECONFIG[opus]         = "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[pango]        = "--enable-pango,--disable-pango,pango"
PACKAGECONFIG[png]          = "--enable-png,--disable-png,libpng"
PACKAGECONFIG[theora]       = "--enable-theora,--disable-theora,libtheora"
PACKAGECONFIG[visual]       = "--enable-libvisual,--disable-libvisual,libvisual"
PACKAGECONFIG[vorbis]       = "--enable-vorbis,--disable-vorbis,libvorbis"
PACKAGECONFIG[x11]          = "${X11ENABLEOPTS},${X11DISABLEOPTS},${X11DEPENDS}"
PACKAGECONFIG[wayland]      = ",,wayland"
PACKAGECONFIG[zlib]         = "--enable-zlib,--disable-zlib,zlib"

EXTRA_OECONF_remove = "--disable-gtk-doc"

FILES_${PN}-dev += "${libdir}/gstreamer-${LIBV}/include/gst/gl/gstglconfig.h"
FILES_${MLPREFIX}libgsttag-1.0 += "${datadir}/gst-plugins-base/1.0/license-translations.dict"

do_configure_prepend() {
	${S}/autogen.sh --noconfigure
}

do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/gst-libs/gst/tag/.libs:${B}/gst-libs/gst/video/.libs:${B}/gst-libs/gst/audio/.libs:${B}/gst-libs/gst/rtp/.libs:${B}/gst-libs/gst/sdp/.libs:${B}/gst-libs/gst/allocators/.libs"
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
FILESPATH_prepend := "${THISDIR}/${PN}:${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
