FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.11"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "57d3dcea476e924eb6eeeb7a585692edf5c8bd23"

require linux-stable.inc
