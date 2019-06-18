# Copyright (C) SUMOMO Computer Assocation
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk1808"

require conf/machine/include/tune-cortexa35.inc
require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc

SERIAL_CONSOLES = "1500000;ttyS2"
KERNEL_IMAGETYPE = "Image"
KBUILD_DEFCONFIG = "defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-rockchip"

IMAGE_FSTYPES = "rockchip-gpt-img"
IMAGE_CLASSES = "rockchip-gpt-img"
