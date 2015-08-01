# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

require conf/machine/include/tune-cortexa15.inc

DEFAULTTUNE="cortexa15-neon"
PREFERRED_PROVIDER_virtual/kernel = "linux"
SERIAL_CONSOLES = "115200;ttyS2"
KERNEL_IMAGETYPE = "zImage"
