;第一个数据段的全部变成大写
;第二个数据段的全部变成小写

assume cs:code, ds:data

data segment
    db 'unIx'
    db 'iNFoRmATiOn'
data ends

code segment
    main:
        mov ax, data
        mov ds, ax
        mov bx, 0
        mov cx, 4

        toLower:
            mov al, [bx]
            and al, 11011111B
            mov [bx], al
            inc bx
            loop toLower

        mov bx, 4
        mov cx, 11
        toUpper:
            mov al, [bx]
            or al, 00100000B
            mov [bx], al
            inc bx
            loop toUpper

        mov ax, 4c00h
        int 21h
code ends

end main