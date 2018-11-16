# Copyright (C) 2018 Randy Li <ayaka@soulik.info>
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-graphics/images/rockchip-media-full-image.bb

LICENSE = "MIT"
DESCRIPTION = "Multimedia and GUI image for Rockchip devices."

IMAGE_INSTALL_append = " adwaita-icon-theme gtk+3 gdk-pixbuf"
