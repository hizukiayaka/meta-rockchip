FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.18.20"
KBRANCH ?= "linux-4.18.y"
SRCREV ?= "a9da8725b7a744be3ff0ff44cab2547e4d1e6675"

require linux-stable.inc
