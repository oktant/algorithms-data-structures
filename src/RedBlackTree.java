
import java.sql.ResultSet;

/**
 * Created by oalizada on 12/18/2016.
 */
public class RedBlackTree<E extends Comparable<E>> {
    RedBlackTree<E> left;
    RedBlackTree<E> right;
    RedBlackTree<E> parent;
    E value;
    boolean isRed;
    public static final RedBlackTree Empty = new RedBlackTree<String>();


    public RedBlackTree() {
        value = null;
        parent = null;
        left = right = this;
        isRed = false;
    }

    public RedBlackTree(E value) {
        this.value = value;
        parent = null;
        left = right = new RedBlackTree<E>();
        isRed = false;
    }

    private boolean isRed() {
        return isRed;
    }

    private void setRed() {
        isRed = true;
    }

    protected void setRed(boolean isRed) {
        this.isRed = isRed;

    }

    private void setBlack() {
        isRed = false;
    }

    protected E getValue() {
        return value;
    }

    protected RedBlackTree<E> left() {
        return left;
    }

    protected RedBlackTree<E> right() {
        return right;
    }

    protected RedBlackTree<E> parent() {
        return parent;
    }

    protected void setParent(RedBlackTree<E> parent) {
        this.parent = parent;

    }

    private boolean isEmpty() {
        return value == null;
    }

    private boolean isRoot() {
        return parent == null;
    }

    public void setLeft(RedBlackTree<E> newLeft) {
        if (isEmpty()) return;
        if (left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(RedBlackTree<E> newRight) {
        if (isEmpty()) return;
        if (right.parent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    public boolean isRightChild() {
        if (parent() == null) {
            return false;
        }
        return this == parent().right();
    }

    public boolean isLeftChild() {
        if (parent() == null) {
            return false;
        }
        return this == parent().left();
    }

    protected RedBlackTree<E> root() {
        RedBlackTree<E> result = this;
        if (!result.isRoot()) {
            result = result.parent();

        }
        return result;
    }

    public int depth() {
        if (parent() == null) return 0;
        return parent.depth() + 1;
    }

    public RedBlackTree<E> add(E c) {
        RedBlackTree<E> tree = insert(c);
        tree.setRed();
        tree.redFixup();
        return tree.root();
    }

    protected void rotateRight() {
        RedBlackTree<E> parent = parent();
        RedBlackTree<E> newRoot = left();
        boolean wasChild=!isRoot();
        boolean wasLeftChild=isLeftChild();
        setLeft(newRoot.right);
        newRoot.setRight(this);
        if(wasChild){
            if(wasLeftChild) parent.setLeft(newRoot);
            else parent.setRight(newRoot);
        }else System.out.println("Root preserves root");
    }

    protected void rotateLeft() {
        RedBlackTree<E> parent = parent();  // could be null
        RedBlackTree<E> newRoot = right();
        boolean wasChild = !isRoot();
        boolean wasRightChild = isRightChild();
        setRight(newRoot.left());
        newRoot.setLeft(this);

        if (wasChild) {
            if (wasRightChild) parent.setRight(newRoot);
            else               parent.setLeft(newRoot);
        } else System.out.println("Root");
    }

    public RedBlackTree<E> insert(E c) {
        if (isEmpty()) return new RedBlackTree<E>(c);

        if (c.compareTo(getValue()) < 0) {
            if (left().isEmpty()) {
                RedBlackTree<E> res = new RedBlackTree<E>(c);
                setLeft(res);
                return res;
            } else {
                return left().insert(c);
            }

        } else {
            if (right().isEmpty()) {
                RedBlackTree<E> res = new RedBlackTree<>();
                setRight(res);
                return res;
            } else {
                return right().insert(c);
            }
        }
    }

    public void redFixup(){
        if (isRoot() || !parent().isRed()) {
            // ensure that root is black (might have been insertion pt)
            root().setBlack();
        } else {
            RedBlackTree<E> parent = parent();  
           
            RedBlackTree<E> grandParent = parent.parent();
            RedBlackTree<E> aunt;  

            if (parent.isLeftChild())
            {
                aunt = grandParent.right();
                if (aunt.isRed()) {
                    
                    grandParent.setRed();
                    aunt.setBlack();
                    parent.setBlack();
                    grandParent.redFixup();
                } else {
                    if (isRightChild()) {
                       
                        parent.rotateLeft();
                        parent.redFixup(); 
                    } else {
                      
                        grandParent.rotateRight();
                        grandParent.setRed();
                        parent.setBlack();
                    }
                }
            } else 
            {
                aunt = grandParent.left();
                if (aunt.isRed()) {

                    grandParent.setRed();
                    aunt.setBlack();
                    parent.setBlack();
                    grandParent.redFixup();
                } else {
                    if (isLeftChild()) {

                        parent.rotateRight();
                        parent.redFixup();
                    } else {

                        grandParent.rotateLeft();
                        grandParent.setRed();
                        parent.setBlack();
                    }
                }
            }
        }
    }
    protected boolean isBlack()
    {
        return !isRed;
    }
    public RedBlackTree<E> locate(E c){
        if(isEmpty()) return null;
        if(c.compareTo(getValue())==0){
            return this;
        }
        else if(c.compareTo(getValue())>0){
            return right().locate(c);
        }
        else
            return left().locate(c);

    }
    public E get(E c){
        if(locate(c)==null) return null;
        else
            return locate(c).getValue() ;
    }
    public void inOrder(){
        if(isEmpty())return;
        left().inOrder();
        System.out.println(getValue());
        right().inOrder();





    }
    public void postOrder(){
        if(isEmpty())return;
        left().postOrder();
        right().postOrder();
        System.out.println(getValue());


    }


    public void preOrder(){
        if(isEmpty()) return;
        System.out.println(getValue());
        left().preOrder();
        right().preOrder();

    }
    protected void blackFixup()
    {

        if (isRoot() || isRed())
        {
            setBlack();
        } else {
            RedBlackTree<E> sibling, parent;

            parent = parent();

            if (isLeftChild())
            {

                sibling = parent.right();

                if (sibling.isRed())
                {

                    sibling.setBlack();
                    parent.setRed();
                    parent.rotateLeft();
                    blackFixup();
                } else
                if (sibling.left().isBlack() && sibling.right().isBlack())
                {

                    sibling.setRed();
                    parent.blackFixup();
                } else {
                    if (sibling.right().isBlack())
                    {

                        sibling.left().setBlack();
                        sibling.setRed();
                        sibling.rotateRight();
                        sibling = parent.right();
                    }

                    sibling.setRed(parent.isRed());
                    parent.setBlack();
                    sibling.right().setBlack();
                    parent.rotateLeft();
                }
            } else {
                sibling = parent.left();

                if (sibling.isRed())
                {

                    sibling.setBlack();
                    parent.setRed();
                    parent.rotateRight();
                    blackFixup();
                } else
                if (sibling.left().isBlack() && sibling.right().isBlack())
                {

                    sibling.setRed();
                    parent.blackFixup();
                } else {
                    if (sibling.left().isBlack())
                    {

                        sibling.right().setBlack();
                        sibling.setRed();
                        sibling.rotateLeft();
                        sibling = parent.left();
                    }

                    sibling.setRed(parent.isRed());
                    parent.setBlack();
                    sibling.left().setBlack();
                    parent.rotateRight();
                    root().blackFixup();
                }
            }
        }
    }

}
