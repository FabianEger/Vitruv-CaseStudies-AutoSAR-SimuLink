package mir.routines.pcm2EjbJava;

import java.io.IOException;
import java.util.Collections;
import mir.routines.pcm2EjbJava.RoutinesFacade;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.impl.ImportsFactoryImpl;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.impl.MembersFactoryImpl;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import tools.vitruv.applications.pcmjava.util.pcm2java.Pcm2JavaHelper;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class AddRequiredRoleRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private AddRequiredRoleRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getCorrepondenceSourceRequiredInterface(final OperationRequiredRole requiredRole) {
      OperationInterface _requiredInterface__OperationRequiredRole = requiredRole.getRequiredInterface__OperationRequiredRole();
      return _requiredInterface__OperationRequiredRole;
    }
    
    public EObject getElement1(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport) {
      return requiredInterfaceImport;
    }
    
    public EObject getCorrepondenceSourceJavaClass(final OperationRequiredRole requiredRole, final Interface requiredInterface) {
      InterfaceRequiringEntity _requiringEntity_RequiredRole = requiredRole.getRequiringEntity_RequiredRole();
      return _requiringEntity_RequiredRole;
    }
    
    public EObject getElement4(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport, final Field requiredInterfaceField) {
      return requiredRole;
    }
    
    public EObject getElement2(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport) {
      return requiredRole;
    }
    
    public EObject getElement3(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport, final Field requiredInterfaceField) {
      return requiredInterfaceField;
    }
    
    public void updateRequiredInterfaceFieldElement(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport, final Field requiredInterfaceField) {
      final NamespaceClassifierReference typeRef = Pcm2JavaHelper.createNamespaceClassifierReference(requiredInterface);
      final String requiredRoleName = requiredRole.getEntityName();
      Pcm2JavaHelper.createPrivateField(requiredInterfaceField, EcoreUtil.<NamespaceClassifierReference>copy(typeRef), requiredRoleName);
    }
    
    public void updateRequiredInterfaceImportElement(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport) {
      Pcm2JavaHelper.addImportToCompilationUnitOfClassifier(requiredInterfaceImport, javaClass, requiredInterface);
    }
    
    public void callRoutine1(final OperationRequiredRole requiredRole, final Interface requiredInterface, final org.emftext.language.java.classifiers.Class javaClass, final ClassifierImport requiredInterfaceImport, final Field requiredInterfaceField, @Extension final RoutinesFacade _routinesFacade) {
      Pcm2JavaHelper.addImportToClassFromString(javaClass, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("javax", "ejb")), "EJB");
      Pcm2JavaHelper.addAnnotationToAnnotableAndModifiable(requiredInterfaceField, "EJB");
      EList<Member> _members = javaClass.getMembers();
      _members.add(requiredInterfaceField);
    }
  }
  
  public AddRequiredRoleRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final OperationRequiredRole requiredRole) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.pcm2EjbJava.AddRequiredRoleRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.pcm2EjbJava.RoutinesFacade(getExecutionState(), this);
    this.requiredRole = requiredRole;
  }
  
  private OperationRequiredRole requiredRole;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine AddRequiredRoleRoutine with input:");
    getLogger().debug("   OperationRequiredRole: " + this.requiredRole);
    
    Interface requiredInterface = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceRequiredInterface(requiredRole), // correspondence source supplier
    	Interface.class,
    	(Interface _element) -> true, // correspondence precondition checker
    	null);
    if (requiredInterface == null) {
    	return;
    }
    registerObjectUnderModification(requiredInterface);
    org.emftext.language.java.classifiers.Class javaClass = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceJavaClass(requiredRole, requiredInterface), // correspondence source supplier
    	org.emftext.language.java.classifiers.Class.class,
    	(org.emftext.language.java.classifiers.Class _element) -> true, // correspondence precondition checker
    	null);
    if (javaClass == null) {
    	return;
    }
    registerObjectUnderModification(javaClass);
    ClassifierImport requiredInterfaceImport = ImportsFactoryImpl.eINSTANCE.createClassifierImport();
    userExecution.updateRequiredInterfaceImportElement(requiredRole, requiredInterface, javaClass, requiredInterfaceImport);
    
    addCorrespondenceBetween(userExecution.getElement1(requiredRole, requiredInterface, javaClass, requiredInterfaceImport), userExecution.getElement2(requiredRole, requiredInterface, javaClass, requiredInterfaceImport), "");
    
    Field requiredInterfaceField = MembersFactoryImpl.eINSTANCE.createField();
    userExecution.updateRequiredInterfaceFieldElement(requiredRole, requiredInterface, javaClass, requiredInterfaceImport, requiredInterfaceField);
    
    addCorrespondenceBetween(userExecution.getElement3(requiredRole, requiredInterface, javaClass, requiredInterfaceImport, requiredInterfaceField), userExecution.getElement4(requiredRole, requiredInterface, javaClass, requiredInterfaceImport, requiredInterfaceField), "");
    
    userExecution.callRoutine1(requiredRole, requiredInterface, javaClass, requiredInterfaceImport, requiredInterfaceField, actionsFacade);
    
    postprocessElements();
  }
}
