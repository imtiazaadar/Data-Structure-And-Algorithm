/**
 * @author: Imtiaz Adar
 */
#include<bits/stdc++.h>
int main(){
    int row, col;
    std::cout << "Enter the number of rows : " << std::endl;
    std::cin >> row;
    std::cout << "Enter the number of columns : " << std::endl;
    std::cin >> col;
    int** arr = new int*[row];
    for(int i = 0; i < row; i++){
        arr[i] = new int[col];
    }
    std::cout << "Taking inputs : " << std::endl;
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            std::cin >> arr[i][j];
        }
    }
    std::cout << "Printing" << std::endl;
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            std::cout << arr[i][j] << " ";
        }
        std::cout << std::endl;
    }
    for(int i = 0; i < row; i++){
        delete[] arr[i];
    }
    delete[] arr;
    arr = NULL;
}