#include <iostream>
#include <stack>

using namespace std;
int main()
{
    stack<int> randomsize;
    int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < 10; i++)
    {
        randomsize.push(array[i]);
    }

    while (!randomsize.empty())
    {
        cout << randomsize.top() << endl;
        randomsize.pop();
    }
}