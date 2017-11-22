# Copyright (C) 2019 SUMOMO Computer Assocation
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

include u-boot-rockchip.inc

DESCRIPTION = "Rockchip U-Boot"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRC_URI = " \
	git://github.com/rockchip-linux/u-boot.git;branch=release; \
	file://binutils-2.28-ld-fix.patch \
	file://gcc7_fixup.patch \
	"

S = "${WORKDIR}/git"
PV = "v2019.01"
