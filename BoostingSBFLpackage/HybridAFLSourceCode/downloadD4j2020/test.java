package downloadD4j2020;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Text;

import org.apache.poi.hslf.dev.SlideAndNotesAtomListing;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.ChildPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

import TestCaseUtile.ASTUtil;




public class test {
	
	//public static Map<Integer, DataNode> Nodes = new HashMap<Integer, DataNode>();
	public static int ID = 0;//�ڵ����ʱ���ڵ��ţ���0��ʼ��ע��ID������Ǹ�ȫ�ֱ���
	
	//��ȡ�ýڵ��ֱ���ӽڵ㣬Ҳ�������Ϊ1���ӽڵ㣬����Ϊ�ڵ��Լ��ڵ�ı��
	public static void getDirectChildren(ASTNode node, int label, Map<Integer, DataNode> Nodes){
		
		//�ȴ���һ���ڵ����ݽṹ
		DataNode myNode = new DataNode();
		Nodes.put(label, myNode);
		myNode.label = label;
		myNode.node = node;
		myNode.numberOfToken = getNumberOfTokens(node);
		myNode.nodeType = node.getClass().toString();
		myNode.attachedStatementType = getAttachedStatementInformation(node);
		getContraolInformation(myNode);
		List listProperty = node.structuralPropertiesForType();
		

		boolean hasChildren = false;
		for(int i = 0; i < listProperty.size(); i++){
			StructuralPropertyDescriptor propertyDescriptor = (StructuralPropertyDescriptor) listProperty.get(i);
			if(propertyDescriptor instanceof ChildListPropertyDescriptor){//ASTNode�б�
				ChildListPropertyDescriptor childListPropertyDescriptor = (ChildListPropertyDescriptor)propertyDescriptor;
				Object children = node.getStructuralProperty(childListPropertyDescriptor);
				List<ASTNode> childrenNodes = (List<ASTNode>)children;
				for(ASTNode childNode: childrenNodes){
					//��ȡ���нڵ�
					if(childNode == null)
						continue;
					hasChildren = true;
					myNode.childrenNodes.add(childNode);
					myNode.childrenLables.add((++ID));
					getDirectChildren(childNode, ID, Nodes);//�����ݹ�
					//System.out.println("childrenList:   "+childNode+"   "+childNode.getClass());
				}
				
			}else if(propertyDescriptor instanceof ChildPropertyDescriptor){//һ��ASTNode
				ChildPropertyDescriptor childPropertyDescriptor = (ChildPropertyDescriptor)propertyDescriptor;
				Object child = node.getStructuralProperty(childPropertyDescriptor);
				ASTNode childNode = (ASTNode)child;
				if(childNode == null)
					continue;
				hasChildren = true;
				//��ȡ������ڵ�
				myNode.childrenNodes.add(childNode);
				myNode.childrenLables.add((++ID));
				getDirectChildren(childNode, ID, Nodes);//�����ݹ�
				
				//System.out.println("child:   "+childNode +"  "+childNode.getClass());
			}
		}
		if(hasChildren){
			//���еݹ��ӽڵ�
			myNode.isLeaf = false;
			int cnt = 0;
			for(Integer it: myNode.childrenLables){
				DataNode dataNode = Nodes.get(it);
				cnt += dataNode.numberOfToken2;
			}
			myNode.numberOfToken2 = cnt;
		}
		else{
			//��������Ҷ�ӽ��
			myNode.isLeaf = true;
			myNode.numberOfToken2 = 1;
		}
	}
	
	public static int getNumberOfTokens(ASTNode node){
		String string = node.toString();
		int cnt = 0;
		for(int i = 0; i < string.length(); i++){
			int value = Integer.valueOf(string.charAt(i));
			if(value >= 1 && value <= 127){
				cnt++;
			}
		}
		return cnt;
	}
	
	

	
	
	
	


	
	// ����statement���������ƣ�����statement�Ļ�����"null"
	public  static String getParentStatementInformation(ASTNode node){
		if((node instanceof AssertStatement) || (node instanceof BreakStatement)
				|| (node instanceof ConstructorInvocation) || (node instanceof ContinueStatement)
				|| (node instanceof DoStatement) || (node instanceof EmptyStatement)
				|| (node instanceof EnhancedForStatement) || (node instanceof ExpressionStatement)
				|| (node instanceof ForStatement) || (node instanceof IfStatement)
				|| (node instanceof LabeledStatement) || (node instanceof ReturnStatement)
				||  (node instanceof SuperConstructorInvocation) || (node instanceof SwitchCase)
				||  (node instanceof SwitchStatement) || (node instanceof SynchronizedStatement)
				|| (node instanceof ThrowStatement) || (node instanceof TryStatement)
				|| (node instanceof TypeDeclarationStatement) || (node instanceof VariableDeclarationStatement)
				|| (node instanceof WhileStatement )){
			return node.getClass().toString();
		}
		return "null";
	}
	
	
	//�ҵ�node������statement���ͣ��������͵����֣��Ҳ�������"null"
	public static String getAttachedStatementInformation(ASTNode node){
		String result = getParentStatementInformation(node);
		if(!result.equals("null")){
			return result;
		}
		ASTNode tp = node;
		//System.out.println(node.getParent());
		while(tp.getParent() != null && !(tp.getParent() instanceof CompilationUnit)){
			tp = tp.getParent();
			result = getParentStatementInformation(tp);
			if(!result.equals("null")){
				return result;
			}
		}
		return "null";
	}
	
	

	
	
	

	
	//2020062029�ĳ�ͼƥ����㷨��������������
	public static DataNode getParentNode(DataNode nd,Map<Integer, DataNode> sourceNodes)
	{
		for(int i =0;i< sourceNodes.size();i++)
		{
			List<Integer> childrenLables = sourceNodes.get(i).childrenLables;
			for(int j = 0; j< childrenLables.size();j++)
			{
				if (childrenLables.get(j)==nd.label)
				{
					return sourceNodes.get(i);
				}
			}
		}
		return null;
	}
	
	

	
	
	
	public static List<String> GetAncestorType(DataNode nd,Map<Integer, DataNode> sourceNodes)
	{
		 List<String> NodeTypeList = new ArrayList<>();
		while(getParentNode(nd,sourceNodes)!=null)
		{
			nd = getParentNode(nd,sourceNodes);
			//�����Ҳ�Ҫblock�ˣ���Ϊif������û��{}��Ӱ�����壬���ǻ�����һ��block�ڵ�
			if(!nd.nodeType.toString().equals("class org.eclipse.jdt.core.dom.Block")
					&&(!nd.nodeType.toString().equals("class org.eclipse.jdt.core.dom.TryStatement"))
					){
			NodeTypeList.add(nd.nodeType);
			}
		}
		return NodeTypeList;
	}
	
	
	public static int GetStartLabel(Map<Integer, DataNode> sourceNodes)
	{
		
		for(int i = 0 ; i< sourceNodes.size();i++){
			if(sourceNodes.get(i).nodeType.equals("class org.eclipse.jdt.core.dom.Block"))
			{return i;}
		}
		return 0;
	}
	
	
	
	
	
	public static  List<DataNode> GetSubTreeNodes (DataNode nd,Map<Integer, DataNode> sourceNodes,  List<DataNode> ndlist)
	{
		 ndlist.add(nd);
		 int c = nd.childrenLables.size();
		 for(int i = 0 ; i < c; i ++)
		 {
			 DataNode tmp = sourceNodes.get(nd.childrenLables.get(i));
			
			 ndlist = GetSubTreeNodes (tmp,sourceNodes, ndlist);
		 }
		 return ndlist;
	}
	

	
}
