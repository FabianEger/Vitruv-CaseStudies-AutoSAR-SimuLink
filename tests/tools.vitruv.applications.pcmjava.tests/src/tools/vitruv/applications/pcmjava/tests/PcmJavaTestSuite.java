package tools.vitruv.applications.pcmjava.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.ClassMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.ClassMethodMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.FieldMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.InterfaceMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.JaMoPPParameterMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.MethodMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.PackageMappingTransformationTest;
import tools.vitruv.applications.pcmjava.pojotransformations.editortests.java2pcm.TypeReferenceMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.DataTypeCorrespondenceHelperTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.BasicComponentMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.CollectionDataTypeMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.CompositeComponentMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.InnerDeclarationMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.OperationInterfaceMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.OperationProvidedRoleMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.OperationRequiredRoleMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.OperationSignatureMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.PcmParameterMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.RepositoryMappingTransformaitonTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.ResourceDemandingInternalBehaviorMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.repository.SEFFMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.system.AssemblyContextMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.system.RequiredDelegationConnectorMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.pojotransformations.pcm2java.system.SystemMappingTransformationTest;
import tools.vitruv.applications.pcmjava.tests.transformations.JaMoPPTest;

@SelectClasses({
	JaMoPPTest.class,
	// PCM2Java-POJO Tests
	DataTypeCorrespondenceHelperTest.class,
	BasicComponentMappingTransformationTest.class,
	CollectionDataTypeMappingTransformationTest.class,
	CompositeComponentMappingTransformationTest.class,
	InnerDeclarationMappingTransformationTest.class,
	OperationInterfaceMappingTransformationTest.class,
	OperationProvidedRoleMappingTransformationTest.class,
	OperationRequiredRoleMappingTransformationTest.class,
	OperationSignatureMappingTransformationTest.class,
	PcmParameterMappingTransformationTest.class,
	RepositoryMappingTransformaitonTest.class,
	ResourceDemandingInternalBehaviorMappingTransformationTest.class,
	SEFFMappingTransformationTest.class,
	AssemblyContextMappingTransformationTest.class,
	RequiredDelegationConnectorMappingTransformationTest.class,
	SystemMappingTransformationTest.class,
	// Java2PCM-POJO Tests
	ClassMappingTransformationTest.class,
	ClassMethodMappingTransformationTest.class,
	FieldMappingTransformationTest.class,
	InterfaceMappingTransformationTest.class,
	JaMoPPParameterMappingTransformationTest.class,
	MethodMappingTransformationTest.class,
	PackageMappingTransformationTest.class,
	TypeReferenceMappingTransformationTest.class
})
@Suite
public class PcmJavaTestSuite {

}
