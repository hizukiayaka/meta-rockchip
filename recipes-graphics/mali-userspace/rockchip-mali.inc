DESCRIPTION = "ARM Mali libraries for Rockchip SoCs for a family of Mali GPU"
SECTION = "libs"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"

DEPENDS = "patchelf-native"

PROVIDES += "virtual/mesa virtual/egl virtual/libgles1 virtual/libgles2 virtual/libgbm"
PROVIDES += "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " libwayland-egl", " ", d)}"
PROVIDES += "virtual/opencl-icd virtual/libopencl"

PACKAGES = "${PN} ${PN}-dev"

INSANE_SKIP_${PN} = "ldflags already-stripped"

inherit pkgconfig cmake

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'directfb', 'fbdev', '', d)}"

PACKAGECONFIG[fbdev]   = "-DDP_FEATURE=fbdev"
PACKAGECONFIG[gbm]     = "-DDP_FEATURE=gbm,,libdrm"
PACKAGECONFIG[wayland] = "-DDP_FEATURE=wayland,,libdrm,wayland"
PACKAGECONFIG[x11]     = "-DDP_FEATURE=x11,,virtual/libx11 libdrm libxcb libdri2"

DEFAULT_MALI_LIB_NAME ?= "libMali.so"
EXTRA_OECMAKE = "-DTARGET_SOC=${SOC_FAMILY} -DTARGET_LIB_NAME=${DEFAULT_MALI_LIB_NAME}"

FILES_${PN} = "${libdir}/lib*${SOLIBS} ${sysconfdir}"
FILES_${PN}-dev = "${libdir}/lib*${SOLIBSDEV} ${includedir} ${libdir}/pkgconfig"

# TODO: Not all the mali libraries support GBM
RREPLACES_${PN} = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"
RCONFLICTS_${PN} = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"
RPROVIDES_${PN}_append = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"
RPROVIDES_${PN}_append = " ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "libwayland-egl", "", d)}"
# TODO: Not all the mali libraries support OpenCL
RPROVIDES_${PN}_append = " opencl-headers"
RDEPENDS_${PN}_append = " ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "wayland", "", d)}"
RDEPENDS_${PN}_append = " ${@bb.utils.contains("DISTRO_FEATURES", "x11", "xserver-xorg", "", d)}"
