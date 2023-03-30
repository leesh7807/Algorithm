#include <iostream>
#include <string>
using namespace std;
void moving(int *posK, int *posS, string where); 
// 과하게 풀어 구현해서 묶을 수 있는 부분 묶었다. 케이스 분류를 먼저 해놓고 핵심 처리 부분을 한 번만 쓰도록.
int main()
{
    string king, stone;
    int count;
    cin >> king >> stone >> count;
    int posK[2] = {8 - (int)king[1] + 48, (int)king[0] - 65}; // 행은 8-('숫자'-48), 열은 '알파벳'-65. 48은 '0', 65는 'A'
    int posS[2] = {8 - (int)stone[1] + 48, (int)stone[0] - 65};
    string where;
    for (int i = 0; i < count; i++)
    {
        cin >> where;
        moving(posK, posS, where);
    }
    cout << (char)(posK[1]+65) << (char)(8-posK[0]+48) << endl;
    cout << (char)(posS[1]+65) << (char)(8-posS[0]+48) << endl;
    return 0;
}

void moving(int *posK, int *posS, string where) 
{
    int move[2];
    if(where == "L")
    {
        move[0] = 0;
        move[1] = -1;
    }
    else if(where == "R") 
    {
        move[0] = 0;
        move[1] = 1;
    }
    else if(where == "T") 
    {
        move[0] = -1;
        move[1] = 0;
    }
    else if(where == "B") 
    {
        move[0] = 1;
        move[1] = 0;
    }
    else if(where == "RB") 
    {
        move[0] = 1;
        move[1] = 1;
    }
    else if(where == "LB") 
    {
        move[0] = 1;
        move[1] = -1;
    }
    else if(where == "RT") 
    {
        move[0] = -1;
        move[1] = 1;
    }
    else if(where == "LT") 
    {
        move[0] = -1;
        move[1] = -1;
    }
    if (posK[0] + move[0] > -1 && posK[0] + move[0] < 8 && posK[1] + move[1] > -1 && posK[1] + move[1] < 8)
    {
        if (posK[0] + move[0] == posS[0] && posK[1] + move[1] == posS[1])
        {
            if (posS[0] + move[0] > -1 && posS[0] + move[0] < 8 && posS[1] + move[1] > -1 && posS[1] + move[1] < 8)
            {
                posS[0] += move[0];
                posS[1] += move[1];
            }
            else
            {
                return;
            }
        }
        posK[0] += move[0];
        posK[1] += move[1];
    }
}