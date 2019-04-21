# Copyright (C) 2018 Randy 'ayaka' Li <ayaka@soulik.info>
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3036"

require conf/machine/include/tune-cortexa7.inc
require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc

SERIAL_CONSOLES = "115200;ttyS2"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-rockchip"
SPL_BINARY ?= "u-boot-spl-nodtb.bin"

IMAGE_FSTYPES = "rockchip-gpt-img"
IMAGE_CLASSES = "rockchip-gpt-img"
