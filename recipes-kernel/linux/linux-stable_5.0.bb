FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.14"
KBRANCH ?= "linux-5.0.y"
SRCREV ?= "274ede3e1a5fb3d0fd33acafb08993e95972c51f"

require linux-stable.inc
