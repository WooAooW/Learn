;使用 si 和 di 进行字符串的复制

assume cs:code, ds:data

data segment
    db 'welcome to masm!'
    db '................'
data ends

code segment

    main:
        mov ax, data
        mov ds, ax

        mov bx, 0
        mov si, 0
        mov di, 16

        mov cx, 16
        s:
            mov al, ds:[bx + si]
            mov ds:[bx + di], al
            inc bx
            loop s

        mov ax, 4c00h
        int 21h

code ends

end main