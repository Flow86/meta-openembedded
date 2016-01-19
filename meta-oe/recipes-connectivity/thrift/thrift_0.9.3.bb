SUMMARY = "Apache Thrift"
DESCRIPTION =  "A software framework, for scalable cross-language services development"
HOMEPAGE = "https://thrift.apache.org/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4ed21f679b2aafef26eac82ab0c2cbf"

DEPENDS = "thrift-native boost python libevent flex-native bison-native \
           glib-2.0 openssl"

SRC_URI = "git://git-wip-us.apache.org/repos/asf/thrift.git;protocol=https \
"
SRCREV = "61b8a29b0704ccd81b520f2300f5d1bb261fea3e"
S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

inherit pkgconfig cmake pythonnative

export STAGING_INCDIR
export STAGING_LIBDIR
export BUILD_SYS
export HOST_SYS

EXTRA_OECMAKE = "-DWITH_QT4=OFF -DWITH_QT5=OFF"
EXTRA_OECMAKE_class-native = "-DWITH_QT4=OFF -DWITH_QT5=OFF \
             -DBUILD_TESTING=OFF -DBUILD_EXAMPLES=OFF -DWITH_CPP=OFF"
EXTRA_OECMAKE_class-nativesdk = "-DWITH_QT4=OFF -DWITH_QT5=OFF \
             -DBUILD_TESTING=OFF -DBUILD_EXAMPLES=OFF -DWITH_PYTHON=OFF"

do_install_append () {
	ln -sf thrift ${D}/${bindir}/thrift-compiler
}

