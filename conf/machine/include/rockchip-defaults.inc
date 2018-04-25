# meta-rockchip default settings

# kernel
PREFERRED_PROVIDER_virtual/kernel ?= "linux"
LINUX_VERSION_EXTENSION ?= "-rockchip"
KBUILD_DEFCONFIG = "multi_v7_defconfig"
KERNEL_IMAGETYPE = "zImage"

# xserver
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = " \
	xserver-xorg \
	xf86-video-fbturbo \
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-input-keyboard \
	"

# misc
IMAGE_FSTYPES += "ext4"
