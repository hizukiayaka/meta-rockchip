# Copyright (C) 2017 Randy Li <ayaka@soulik.info>
# Released under the MIT license (see COPYING.MIT for the terms)
# Put the following options into your local.conf
#PREFERRED_PROVIDER_virtual/mesa = "mesa-gl"
#PREFERRED_PROVIDER_virtual/libgl = "mesa-gl"
#PREFERRED_PROVIDER_virtual/egl = "rockchip-mali"
#PREFERRED_PROVIDER_virtual/libgles1 = "rockchip-mali"
#PREFERRED_PROVIDER_virtual/libgles2 = "rockchip-mali"
#PREFERRED_PROVIDER_virtual/libopencl = "rockchip-mali"
#DISTRO_FEATURES_remove = "x11"
#DISTRO_FEATURES_remove = "vulkan"
#DISTRO_FEATURES_NATIVESDK_remove = "x11"
#DISTRO_FEATURES_NATIVESDK_remove = "vulkan"
#DISTRO_FEATURES_append = " wayland"
#DISTRO_FEATURES_NATIVESDK_append = " wayland"
#LICENSE_FLAGS_WHITELIST = "commercial_gstreamer1.0-libav \
# commercial_rockchip-mali"

include recipes-multimedia/images/rockchip-media-image.bb

LICENSE = "MIT"
DESCRIPTION = "Multimedia and GUI image for Rockchip devices."

IMAGE_INSTALL_append = " weston weston-init rockchip-mali pulseaudio-server \
  gstreamer1.0-plugins-base-alsa gstreamer1.0-plugins-base-app \
  gstreamer1.0-plugins-base-tcp gstreamer1.0-plugins-good-udp \
  gstreamer1.0-plugins-good-rtp gstreamer1.0-plugins-good-rtpmanager \
  gstreamer1.0-plugins-good-rtsp gstreamer1.0-plugins-good-video4linux2 \
  gstreamer1.0-plugins-good-audioparsers gstreamer1.0-plugins-good-pulseaudio \
  gstreamer1.0-plugins-good-jpeg \
  gstreamer1.0-plugins-bad-waylandsink gstreamer1.0-plugins-bad-mpegtsmux \
  gstreamer1.0-plugins-bad-jpegformat \
  gstreamer1.0-libav \
  gstreamer1.0-plugins-base-opengl \
"
