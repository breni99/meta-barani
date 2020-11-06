SUMMARY = "SIMPLE FILE TRANSFER APPLICATION"
LICENSE = "Appache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=68b329da9893e34099c7d8ad5cb9c940"
SRC_URI = "git://github.com:breni99/filetransfer.git;protocol=git;branch=main"
SRCREV = "616e6d5c552540bb511e4b89fb29e06d11fd3efa"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"
do_compile() {
        ${CC} fileserver.c ${LDFLAGS} -o fileserver
        ${CC} filedownloader.c ${LDFLAGS} -o filedownloader
}

do_install() {
        install -d ${D}${bindir}/go
        install -Dm 0755 ${WORKDIR}/git/sentfile.txt ${D}${bindir}/go
        install -m 0756 fileserver ${D}${bindir}
        install -m 0757 filedownloader ${D}${bindir}
}
FILES_{PN} = "${bindir}/*"
