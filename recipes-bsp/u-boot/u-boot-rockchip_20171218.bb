# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

include u-boot-rockchip.inc

TAG = "release-${PV}"
SRC_URI = " \
	git://github.com/rockchip-linux/u-boot.git;tag=${TAG};nobranch=1; \
	file://binutils-2.28-ld-fix.patch \
	file://gcc7_fixup.patch \
"
S = "${WORKDIR}/git"

SRCREV = "release-20171218"
