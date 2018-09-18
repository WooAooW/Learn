;在屏幕中间分别显示 绿色，绿底红色，白底蓝色 的字符串 'welcome to masm!'
;B8000 ~ BFFFF 显示缓冲区，分8页

;显示一个字符，占用两个字节，低位存储 ASCII，高位存储字符属性

;字符属性
;7    6 5 4   3   2 1 0
;BL   R G B   I   R G B
;闪烁  背景   高亮   前景

;0 100 0 010B 红底绿字

;00000010B 绿色

assume cs:code, ds:data

data segment
	db 'welcome to masm!'
data ends

code segment
	main:
		mov ax, data
		mov ds, ax
		mov ax, 0B800H
		mov es, ax
		mov si, 0
		mov di, 0

		mov ax, 16  ;一共16个字
		mov cx, ax

	print:
		mov al, ds:[si]
		mov es:[di], al
		mov byte ptr es:[di + 1], 00000010B
		inc si
		inc di
		loop print

	mov ax, 4c00h
	int 21h

code ends

end main