# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Copyright (C) 2017 Trevor Woerner <twoerner@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "Rockchip next-dev U-Boot"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
COMPATIBLE_MACHINE = "(rk3036|rk3066|rk3188|rk3288|rk3328|rk3399)"

DEPENDS = "dtc-native bc-native swig-native"

# u-boot will build native python module
inherit pythonnative

do_configure () {
	if [ -z "${UBOOT_CONFIG}" ]; then
	    if [ -n "${UBOOT_MACHINE}" ]; then
	        oe_runmake -C ${S} O=${B} ${UBOOT_MACHINE}
	    else
	        oe_runmake -C ${S} O=${B} oldconfig
	    fi
	    cml1_do_configure
	fi
}

do_compile_prepend () {
	export STAGING_INCDIR=${STAGING_INCDIR_NATIVE};
	export STAGING_LIBDIR=${STAGING_LIBDIR_NATIVE};
}

do_compile_append () {
	# copy to default search path
	if [ ${SPL_BINARY} ]; then
		cp ${B}/spl/${SPL_BINARY} ${B}/
	fi
}
