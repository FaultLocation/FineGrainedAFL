package downloadD4j2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.jdt.core.dom.ASTNode;

public class DataNode {
	public ASTNode node; //������ĵ�AST�ڵ�
	public int label; //���
	public List<Integer> childrenLables = new ArrayList<>(); //ֱ�ӵ��ӽڵ�ı��
	public List<ASTNode> childrenNodes = new ArrayList<>(); //ֱ�ӵ��ӽڵ�
	public boolean isLeaf = false; //�Ƿ���Ҷ�ӽڵ�
	public String nodeType = "unknown";
	public String attachedStatementType = "null";
	public List<Integer> logicPoseList = new ArrayList<>();
	public static double score = -1;
	public int numberOfToken = 0;
	public int numberOfToken2 = 0;
	public int numberOfWrongTestCase = 0; //Ϊ�˼�����ʣ����в�������ʧ�ܵ�����£��ýڵ����еĴ���
	public int numberOfTotalTestCase = 0; //���еĲ����������ýڵ������˶��ٴ�

	
}
