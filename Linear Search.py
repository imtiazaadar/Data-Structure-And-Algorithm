# Imtiaz Adar
# Linear Search

def linear_search(li, element):
    for index in range(len(li)):
        if li[index] == element:
            return index
    return -1

li = [10, 20, 30, 40, 50, 60, 70]
element = int(input('Enter element which you want to search : '))
pos = linear_search(li, element)
if pos != -1:
    print(f'Element in {pos} position')
else:
    print('Element not found!!!')
