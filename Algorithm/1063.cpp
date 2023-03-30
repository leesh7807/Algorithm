#include <iostream>
#include <string>
using namespace std;

// 러프하게 구현하자.
int main()
{
    string king, stone;
    int count;
    cin >> king >> stone >> count;
    int posK[2] = {8 - (int)king[1] + 48, (int)king[0] - 65}; // 행은 8-'숫자'+48, 열은 '알파벳'-65
    int posS[2] = {8 - (int)stone[1] + 48, (int)stone[0] - 65};
    string where;
    for (int i = 0; i < count; i++)
    {
        cin >> where;
        if (where == "R")
        {
            int move[2] = {0, 1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "L")
        {
            int move[2] = {0, -1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "B")
        {
            int move[2] = {1, 0};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "T")
        {
            int move[2] = {-1, 0};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "RT")
        {
            int move[2] = {-1, 1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "LT")
        {
            int move[2] = {-1, -1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "RB")
        {
            int move[2] = {1, 1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
        else if (where == "LB")
        {
            int move[2] = {1, -1};
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
                        continue;
                    }
                }
                posK[0] += move[0];
                posK[1] += move[1];
            }
        }
    }
    cout << (char)(posK[1]+65) << (char)(8-posK[0]+48) << endl;
    cout << (char)(posS[1]+65) << (char)(8-posS[0]+48) << endl;
    return 0;
}