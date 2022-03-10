package net.adoptium.marketplace.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Details of a binary that can be downloaded including either or both a package and platform specific installer")
public class Binary {

    public static final String IMAGE_TYPE_NAME = "image_type";
    public static final String C_LIB_NAME = "c_lib";
    public static final String JVM_IMPL_NAME = "jvm_impl";
    public static final String PACKAGE_NAME = "package";
    public static final String SCM_REF_NAME = "scm_ref";
    public static final String OPENJDK_SCM_REF_NAME = "openjdk_scm_ref";
    public static final String AQAVIT_RESULTS_LINK_NAME = "aqavit_results_link";
    public static final String TCK_AFFIDAVIT_LINK_NAME = "tck_affidavit_link";
    public static final String OS_NAME = "os";
    public static final String ARCHITECTURE_NAME = "architecture";
    public static final String INSTALLER_NAME = "installer";
    public static final String TIMESTAMP_NAME = "timestamp";
    public static final String PROJECT_NAME = "project";
    public static final String DISTRIBUTION_NAME = "distribution";

    @Schema(implementation = OperatingSystem.class, required = true)
    private final OperatingSystem os;

    @Schema(implementation = Architecture.class, required = true)
    private final Architecture architecture;

    @Schema(
        name = IMAGE_TYPE_NAME,
        implementation = ImageType.class,
        required = true)
    private final ImageType imageType;

    @Schema(
        name = C_LIB_NAME,
        implementation = CLib.class
    )
    private final CLib cLib;

    @Schema(
        implementation = JvmImpl.class,
        name = JVM_IMPL_NAME,
        required = true)
    private final JvmImpl jvmImpl;

    @Schema(
        implementation = Package.class, description = "Describes details of the archive",
        name = PACKAGE_NAME,
        required = false)
    private final Package _package;

    @Schema(implementation = Installer.class,
        description = "Describes details of the installer archive associated with this binary",
        required = false)
    private final Installer installer;

    @Schema(required = true, description = "Timestamp of the creation time of the binary")
    private final Date timestamp;

    @Schema(description = "Scm reference to the commit inside the vendors own repository upon which this build is based",
        name = SCM_REF_NAME,
        example = "dd28d6d2cde2b931caf94ac2422a2ad082ea62f0beee3bf7057317c53093de93",
        required = true)
    private final String scmRef;

    @Schema(description = "Scm reference to the commit inside the OpenJDK project, upon which this build is based",
        name = OPENJDK_SCM_REF_NAME,
        example = "dd28d6d2cde2b931caf94ac2422a2ad082ea62f0beee3bf7057317c53093de93",
        required = true)
    private final String openjdkScmRef;

    @Schema(implementation = Project.class, required = true)
    private final Project project;

    @Schema(implementation = Distribution.class, required = true)
    private final Distribution distribution;

    @Schema(required = true,
        name = AQAVIT_RESULTS_LINK_NAME,
        description = "Link to the aquavit results details for this binary",
        example = "https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17%2B35/OpenJDK17-jdk_x64_linux_hotspot_17_35.tar.gz.aqavit.zip")
    private final String aqavitResultsLink;

    @Schema(required = true,
        name = TCK_AFFIDAVIT_LINK_NAME,
        example = "https://adoptium.net/tck_affidavit.html",
        description = "Link to the tck affidavit for this binary")
    private final String tckAffidavitLink;

    @JsonCreator
    public Binary(
        @JsonProperty(OS_NAME) OperatingSystem os,
        @JsonProperty(ARCHITECTURE_NAME) Architecture architecture,
        @JsonProperty(IMAGE_TYPE_NAME) ImageType imageType,
        @JsonProperty(C_LIB_NAME) CLib cLib,
        @JsonProperty(JVM_IMPL_NAME) JvmImpl jvmImpl,
        @JsonProperty(PACKAGE_NAME) Package aPackage,
        @JsonProperty(INSTALLER_NAME) Installer installer,
        @JsonProperty(TIMESTAMP_NAME) Date timestamp,
        @JsonProperty(SCM_REF_NAME) String scmRef,
        @JsonProperty(OPENJDK_SCM_REF_NAME) String openjdkScmRef,
        @JsonProperty(PROJECT_NAME) Project project,
        @JsonProperty(DISTRIBUTION_NAME) Distribution distribution,
        @JsonProperty(AQAVIT_RESULTS_LINK_NAME) String aqavitResultsLink,
        @JsonProperty(TCK_AFFIDAVIT_LINK_NAME) String tckAffidavitLink
    ) {
        this.os = os;
        this.architecture = architecture;
        this.imageType = imageType;
        this.cLib = cLib;
        this.jvmImpl = jvmImpl;
        _package = aPackage;
        this.installer = installer;
        this.timestamp = timestamp;
        this.scmRef = scmRef;
        this.openjdkScmRef = openjdkScmRef;
        this.project = project;
        this.distribution = distribution;
        this.aqavitResultsLink = aqavitResultsLink;
        this.tckAffidavitLink = tckAffidavitLink;
    }

    @JsonProperty(OS_NAME)
    public OperatingSystem getOs() {
        return os;
    }

    @JsonProperty(ARCHITECTURE_NAME)
    public Architecture getArchitecture() {
        return architecture;
    }

    @JsonProperty(IMAGE_TYPE_NAME)
    public ImageType getImageType() {
        return imageType;
    }

    @JsonProperty(C_LIB_NAME)
    public CLib getCLib() {
        return cLib;
    }

    @JsonProperty(JVM_IMPL_NAME)
    public JvmImpl getJvmImpl() {
        return jvmImpl;
    }

    @JsonProperty(PACKAGE_NAME)
    public Package getPackage() {
        return _package;
    }

    @JsonProperty(INSTALLER_NAME)
    public Installer getInstaller() {
        return installer;
    }

    @JsonProperty(TIMESTAMP_NAME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    public Date getTimestamp() {
        return timestamp;
    }

    @JsonProperty(SCM_REF_NAME)
    public String getScmRef() {
        return scmRef;
    }

    @JsonProperty(PROJECT_NAME)
    public Project getProject() {
        return project;
    }

    @JsonProperty(DISTRIBUTION_NAME)
    public Distribution getDistribution() {
        return distribution;
    }

    @JsonProperty(AQAVIT_RESULTS_LINK_NAME)
    public String getAqavitResultsLink() {
        return aqavitResultsLink;
    }

    @JsonProperty(TCK_AFFIDAVIT_LINK_NAME)
    public String getTckAffidavitLink() {
        return tckAffidavitLink;
    }

    @JsonProperty(OPENJDK_SCM_REF_NAME)
    public String getOpenjdkScmRef() {
        return openjdkScmRef;
    }
}
