# Imtiaz Adar
# Binary Search Tree

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def insert(root, data):
    if root is None:
        return Node(data)
    else:
        if root.data == data:
            return root
        elif root.data > data:
            root.left = insert(root.left, data)
        else:
            root.right = insert(root.right, data)
    return root

def search(root, key):
    if root is None:
        return None
    elif key < root.data:
        return search(root.left, key)
    elif key > root.data:
        return search(root.right, key)
    return root

def remove(root, data):
    if root is None:
        return None
    elif data < root.data:
        root.left = remove(root.left, data)
    elif data > root.data:
        root.right = remove(root.right, data)
    else:
        if root.left is None:
            return root.right
        elif root.right is None:
            return root.left
        temp = findMin(root.right)
        root.data = temp.data
        root.right = remove(root.right, root.data)
    return root

def find(root, val):
    if search(root, val) is not None:
        print(f'{val} found !!!')
    else:
        print(f'{val} not found !!!')

def findMin(root):
    while root.left:
        root = root.left
    return root

def findMax(root):
    while root.right:
        root = root.right
    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(f'->{root.data}', end=' ')
        inorder(root.right)

def preorder(root):
    if root:
        print(f'->{root.data}', end=' ')
        preorder(root.left)
        preorder(root.right)

def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(f'->{root.data}', end=' ')

root = Node(25)
insert(root, 15)
insert(root, 24)
insert(root, 12)
insert(root, 14)
insert(root, 30)
inorder(root)
print()
remove(root, 14)
inorder(root)
print()
find(root, 30)