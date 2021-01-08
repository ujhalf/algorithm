# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')


# See PyCharm help at https://www.jetbrains.com/help/pycharm/

def max_heapify(self, nums, i, length):
    l = i * 2 + 1;
    r = i * 2 + 2;

    # largest记录最大值的索引
    largest = i
    #左孩子存在且大于
    if (l < length and nums[l] > nums[largest]):
        largest = l;
    #右孩子存在且大于
    if (r < length and nums[r] > nums[largest]):
        largest = r;

    if largest != i:
        nums[i],nums[largest]=nums[largest],nums[i]
         self