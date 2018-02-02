;将data端中的每个单词的头一个字母变成大写字母

assume cs:code, ds:data

data segment
	db '1. file         '
	db '2. edit         '
	db '3. search       '
	db '4. view         '
	db '5. options      '
	db '6. help         '
data ends

code segment

	main:
		mov ax, data
		mov ds, ax

		mov bx, 0
		mov si, 3
		mov cx, 6
		s:
			mov al, [bx + si]
			and al, 11011111B
			mov [bx + si], al

			add bx, 16
			loop s

		mov ax, 4c00h
		int 21h

code ends

end main