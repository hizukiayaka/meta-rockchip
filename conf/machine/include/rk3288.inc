# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

require conf/machine/include/tune-cortexa17.inc

PREFERRED_PROVIDER_virtual/kernel = "linux"
SERIAL_CONSOLES = "115200;ttyS2"
KERNEL_IMAGETYPE = "zImage"
KBUILD_DEFCONFIG = "multi_v7_defconfig"
