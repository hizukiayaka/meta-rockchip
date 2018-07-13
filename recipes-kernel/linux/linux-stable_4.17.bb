FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.6"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "b36cc73101fa785ba47f3092fb7517dde0c27da3"

require linux-stable.inc
