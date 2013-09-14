package Controllers;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 14/09/13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Models.Project;
import Models.Task;
import Models.UserStory;
import helpers.ProjectHelper;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "MainView")
public class MainView
{

    private TreeNode root;

    private TreeNode selectedNode;

    public MainView() {
        root = new DefaultTreeNode("root",null);
        /*
        TreeNode node0 = new DefaultTreeNode("Node 0", root);
        TreeNode node1 = new DefaultTreeNode("Node 1", root);
        TreeNode node2 = new DefaultTreeNode("Node 2", root);

        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);

        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);

        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);

        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
        */

        TreeNode projects  = new DefaultTreeNode("project",new Document("Projects",15),root);
        ProjectHelper projecth = ProjectHelper.getInstance();
        List<Project> projectsVal = projecth.getProjectByUser("admin","admin");
        System.out.println("sss:"+projectsVal.size());
        //for (Project objValue : projectsVal)
        for(int i=0;i<projectsVal.size();i++)
        {
            Project objValue = projectsVal.get(i);
            //TreeNode treeNode = new DefaultTreeNode("project",new Document( projectsVal.get(i).getName(),15), projects);
            TreeNode treeNode = new DefaultTreeNode("project",new Document("test",15), projects);

        }
       // fillDataProjects(projects, projectsVal);
       // fillData(projects, projectsVal);

    }

    private void fillDataProjects(TreeNode node, List<Project> values)
    {
        for (Project objValue : values)
        {
            TreeNode treeNode = new DefaultTreeNode("project",new Document(objValue.getName(),15),node);

        }
    }
    private void fillData(TreeNode node, List values )
    {
        for (Object objValue : values)
        {
            DefaultTreeNode treeNode = new DefaultTreeNode();
            String type ="";
            String nameValue ="";
            if (objValue instanceof Project)
            {
                type ="project";
                Project pro = (Project)objValue;
                nameValue = pro.getName();
            }
            else if(objValue instanceof UserStory)
            {
                type ="UserStory";
                UserStory  us = (UserStory)objValue;
                nameValue = us.getNameStory();
            }
            else if (objValue instanceof Task)
            {
                type = "Task";
                Task task = (Task)objValue;
                nameValue = task.getNameTask();
            }
            treeNode.setType(type);
            treeNode.setData(new Document(nameValue,15));
            treeNode.setParent(node);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeExpand(NodeExpandEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expanded", event.getTreeNode().toString());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Collapsed", event.getTreeNode().toString());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onNodeSelect(NodeSelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onNodeUnselect(NodeUnselectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unselected", event.getTreeNode().toString());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
