# Copyright (C) 2019 SUMOMO Computer Association
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3399"

require conf/machine/include/tune-cortexa72.inc
require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc

SERIAL_CONSOLES = "1500000;ttyS2"
KERNEL_IMAGETYPE = "Image"
KBUILD_DEFCONFIG = "defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-rockchip"

IMAGE_FSTYPES = "rockchip-gpt-img"
IMAGE_CLASSES = "rockchip-gpt-img"
