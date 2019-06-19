# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)
DEFAULT_PREFERENCE = "-1"

require recipes-multimedia/gstreamer/gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 "

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
"

SRC_URI = " \
    git://git.sumomo.pri/gstreamer/gst-plugins-bad.git;protocol=ssh;branch=master;name=base \
    git://git.sumomo.pri/gstreamer/common.git;destsuffix=git/common;protocol=ssh;branch=master;name=common \
    file://configure-allow-to-disable-libssh2.patch \
    file://fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
"

S = "${WORKDIR}/git"

SRCREV_FORMAT = "${PV}"
SRCREV = "${AUTOREV}"

DEPENDS += "gstreamer1.0-plugins-base jpeg"

inherit gettext bluetooth gobject-introspection

PACKAGECONFIG ??= " \
    ${GSTREAMER_ORC} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'directfb vulkan', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl', '', d)} \
    bz2 curl dash dtls hls rsvg sbc smoothstreaming sndfile uvch264 webp kms \
"

PACKAGECONFIG[assrender]       = "--enable-assrender,--disable-assrender,libass"
PACKAGECONFIG[bluez]           = "--enable-bluez,--disable-bluez,${BLUEZ}"
PACKAGECONFIG[bz2]             = "--enable-bz2,--disable-bz2,bzip2"
PACKAGECONFIG[curl]            = "--enable-curl,--disable-curl,curl"
PACKAGECONFIG[dash]            = "--enable-dash,--disable-dash,libxml2"
PACKAGECONFIG[dc1394]          = "--enable-dc1394,--disable-dc1394,libdc1394"
PACKAGECONFIG[directfb]        = "--enable-directfb,--disable-directfb,directfb"
PACKAGECONFIG[dtls]            = "--enable-dtls,--disable-dtls,openssl"
PACKAGECONFIG[faac]            = "--enable-faac,--disable-faac,faac"
PACKAGECONFIG[faad]            = "--enable-faad,--disable-faad,faad2"
PACKAGECONFIG[flite]           = "--enable-flite,--disable-flite,flite-alsa"
PACKAGECONFIG[fluidsynth]      = "--enable-fluidsynth,--disable-fluidsynth,fluidsynth"
PACKAGECONFIG[hls]             = "--enable-hls --with-hls-crypto=nettle,--disable-hls,nettle"
PACKAGECONFIG[opengl]          = "--enable-gl,--disable-gl,"
PACKAGECONFIG[kms]             = "--enable-kms,--disable-kms,libdrm"
PACKAGECONFIG[libde265]        = "--enable-libde265,--disable-libde265,libde265"
PACKAGECONFIG[libmms]          = "--enable-libmms,--disable-libmms,libmms"
PACKAGECONFIG[libssh2]         = "--enable-libssh2,--disable-libssh2,libssh2"
PACKAGECONFIG[modplug]         = "--enable-modplug,--disable-modplug,libmodplug"
PACKAGECONFIG[msdk]            = "--enable-msdk,--disable-msdk,intel-mediasdk"
PACKAGECONFIG[neon]            = "--enable-neon,--disable-neon,neon"
PACKAGECONFIG[openal]          = "--enable-openal,--disable-openal,openal-soft"
PACKAGECONFIG[opencv]          = "--enable-opencv,--disable-opencv,opencv"
PACKAGECONFIG[openjpeg]        = "--enable-openjpeg,--disable-openjpeg,openjpeg"
# the opus encoder/decoder elements are now in the -base package,
# but the opus parser remains in -bad
PACKAGECONFIG[opusparse]       = "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[resindvd]        = "--enable-resindvd,--disable-resindvd,libdvdread libdvdnav"
PACKAGECONFIG[rsvg]            = "--enable-rsvg,--disable-rsvg,librsvg"
PACKAGECONFIG[rtmp]            = "--enable-rtmp,--disable-rtmp,rtmpdump"
PACKAGECONFIG[sbc]             = "--enable-sbc,--disable-sbc,sbc"
PACKAGECONFIG[smoothstreaming] = "--enable-smoothstreaming,--disable-smoothstreaming,libxml2"
PACKAGECONFIG[sndfile]         = "--enable-sndfile,--disable-sndfile,libsndfile1"
PACKAGECONFIG[srtp]            = "--enable-srtp,--disable-srtp,libsrtp"
PACKAGECONFIG[tinyalsa]        = "--enable-tinyalsa,--disable-tinyalsa,tinyalsa"
PACKAGECONFIG[uvch264]         = "--enable-uvch264,--disable-uvch264,libusb1 libgudev"
PACKAGECONFIG[voaacenc]        = "--enable-voaacenc,--disable-voaacenc,vo-aacenc"
PACKAGECONFIG[voamrwbenc]      = "--enable-voamrwbenc,--disable-voamrwbenc,vo-amrwbenc"
PACKAGECONFIG[wayland]         = "--enable-wayland,--disable-wayland,wayland-native wayland wayland-protocols libdrm"
PACKAGECONFIG[webp]            = "--enable-webp,--disable-webp,libwebp"
PACKAGECONFIG[webrtc]          = "--enable-webrtc,--disable-webrtc,libnice"
PACKAGECONFIG[webrtcdsp]       = "--enable-webrtcdsp,--disable-webrtcdsp,webrtc-audio-processing"

# these plugins have no corresponding library in OE-core or meta-openembedded:
#   openni2 winks direct3d directsound winscreencap acm apple_media iqa
#   android_media avc bs2b chromaprint daala dts fdkaac gme gsm kate ladspa libde265
#   lv2 mpeg2enc mplex msdk musepack nvenc ofa openh264 opensles soundtouch spandsp
#   spc teletextdec tinyalsa vdpau wasapi x265 zbar webrtcdsp

EXTRA_OECONF += " \
    --enable-decklink \
    --enable-dvb \
    --enable-fbdev \
    --enable-netsim \
    --enable-shm \
    --disable-android_media \
    --disable-apple_media \
    --disable-avc \
    --disable-bs2b \
    --disable-chromaprint \
    --disable-direct3d \
    --disable-directsound \
    --disable-dts \
    --disable-fdk_aac \
    --disable-gme \
    --disable-gsm \
    --disable-iqa \
    --disable-kate \
    --disable-ladspa \
    --disable-lv2 \
    --disable-mpeg2enc \
    --disable-mplex \
    --disable-msdk \
    --disable-musepack \
    --disable-nvenc \
    --disable-ofa \
    --disable-openexr \
    --disable-openh264 \
    --disable-openni2 \
    --disable-opensles \
    --disable-soundtouch \
    --disable-spandsp \
    --disable-teletextdec \
    --disable-tinyalsa \
    --disable-wasapi \
    --disable-webrtcdsp \
    --disable-wildmidi \
    --disable-winks \
    --disable-winscreencap \
    --disable-x265 \
    --disable-zbar \
    ${@bb.utils.contains("TUNE_FEATURES", "mx32", "--disable-yadif", "", d)} \
"

EXTRA_OECONF_remove = "--disable-gtk-doc"

export OPENCV_PREFIX = "${STAGING_DIR_TARGET}${prefix}"

ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/gst-libs/gst/allocators/.libs"
}

do_configure_prepend() {
        ${S}/autogen.sh --noconfigure
}

FILES_${PN}-freeverb += "${datadir}/gstreamer-${LIBV}/presets/GstFreeverb.prs"
FILES_${PN}-opencv += "${datadir}/gst-plugins-bad/${LIBV}/opencv*"
FILES_${PN}-voamrwbenc += "${datadir}/gstreamer-${LIBV}/presets/GstVoAmrwbEnc.prs"

FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/${PN}:"
FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
FILESPATH_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/${PN}:"
FILESPATH_prepend := "${COREBASE}/meta/recipes-multimedia/gstreamer/files:"
