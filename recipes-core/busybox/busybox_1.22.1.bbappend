# Copyright (C) 2015 Romain Perier <romain.perier@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR = "r33"

SRC_URI += "file://0001-udhcp-add-PXELINUX-path-prefix-option-definition.patch"
