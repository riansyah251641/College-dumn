#include <bits/stdc++.h>
#include <boost/multiprecision/cpp_int.hpp>
namespace mp = boost::multiprecision;
using namespace mp;
using namespace std;
const int limit = 1000000007;
int cal(int x1, cpp_int x2)
{
    long long count = 1, data = x1;
    while (x2)
    {
        if (x2 & 1)
            count = count * data;
        if (count >= limit)
            count = count - (count / limit) * limit;
        data = data * data;
        if (data >= limit)
            data = data - (data / limit) * limit;
        x2 >>= 1;
    }
    return count;
}
int main()
{
    int lim;
    cpp_int k1, k2;
    long long output, a1;
    for (scanf("%d", &lim); lim--;)
    {
        cin >> k1 >> k2;
        k2--;
        if (k2 >= limit)
            k2 %= limit;
        output = (long long)k2;
        if (k1 & 1)
            output = output * (-1);
        a1 = cal((int)k2, k1);
        printf("%lld\k1", (a1 + output + limit) % limit);
    }
}