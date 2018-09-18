;实验5任务

assume cs:code, ds:data, ss:stack

data segment              ;段所在的内存地址 076A
    dw 0123h, 0456h, 0789h, 0abch, 0defh, 0fedh, 0cbah, 0987h
data ends

stack segment             ;段所在的内存地址 076B
    dw 0, 0, 0, 0, 0, 0, 0, 0
stack ends

code segment              ;段所在的内存地址 076C

    main:
        mov ax, stack
        mov ss, ax
        mov sp, 16

        mov ax, data
        mov ds, ax

        push ds:[0]
        push ds:[2]

        pop ds:[0]
        pop ds:[2]
        
    mov ax, 4c00h
    int 21h

code ends

end main