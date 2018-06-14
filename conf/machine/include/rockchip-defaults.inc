# meta-rockchip default settings

# kernel
PREFERRED_PROVIDER_virtual/kernel ?= "linux-stable"
LINUX_VERSION_EXTENSION ?= "-rockchip"
KBUILD_DEFCONFIG = "multi_v7_defconfig"
KERNEL_IMAGETYPE = "zImage"

# xserver
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = " \
	xserver-xorg \
	xserver-xorg-utils \
	xserver-xorg-xvfb \
	xserver-xorg-extension-glx \
	xserver-xorg-module-libwfb \
	xserver-xorg-module-exa \
	xf86-video-modesetting \
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-input-keyboard \
	"

# misc
IMAGE_FSTYPES += "ext4"
