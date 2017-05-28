# Copyright (C) 2017 Randy Li <ayaka@soulik.info>
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-core/images/core-image-minimal.bb

LICENSE = "MIT"
DESCRIPTION = "Multimedia image for Rockchip devices."

IMAGE_FEATURES_append = " package-management ssh-server-dropbear"
IMAGE_INSTALL_append = " gdbserver gstreamer1.0-rockchip      \
  gstreamer1.0-meta-base gstreamer1.0-meta-video gstreamer1.0-meta-audio \
  gstreamer1.0-plugins-base-rawparse \
  gstreamer1.0-plugins-good-isomp4 gstreamer1.0-plugins-good-multifile \
  gstreamer1.0-plugins-good-imagefreeze \
  gstreamer1.0-plugins-bad-autoconvert gstreamer1.0-plugins-bad-camerabin \
  gstreamer1.0-plugins-bad-kms gstreamer1.0-plugins-bad-videoparsersbad \
  gstreamer1.0-plugins-bad-mpegtsdemux gstreamer1.0-plugins-bad-jpegformat \
  gstreamer1.0-meta-debug \
"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake-dev nativesdk-meson-dev"
