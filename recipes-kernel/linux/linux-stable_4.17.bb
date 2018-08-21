FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.17"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "fa535b8a37597c80c0ac7d3669edccda9d91195b"

require linux-stable.inc
