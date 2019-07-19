# -
增删查改
list.h
#ifndef _LIST_H_
#define _LIST_H_

typedef int SLTDataType;

typedef struct SListNode{
SLTDataType data;
struct SListNode* next;
}SListNode;

void SListInit(SListNode** pphead);//链表的初始化
void SListDestory(SListNode** pphead);//销毁链表

SListNode* BuySListNode(SLTDataType x);//申请节点
void SListPushFront(SListNode** pphead, SLTDataType x);//头插
void SListPopFront(SListNode** pphead);//头删
void SListInsertAfter(SListNode* pos, SLTDataType x);//在x后插入元素data
void SListEraseAfter(SListNode* pos);//删除POS位置的元素
SListNode*SListFind(SListNode* phead, SLTDataType x);//寻找值为x的节点
void SListRemove(SListNode** pphead, SLTDataType x);//删除指定元素

void SListPrint(SListNode* phead);//打印链表

void SListReverse(SListNode **pphead);
void SListReverse2(SListNode **pphead);

#endif 

list.c
#include"list.h"
#include <stdio.h>

void SListInit(SListNode** pphead)
{
	*pphead = NULL;//将链表置空
}
SListNode* BuySListNode(SLTDataType x) //申请节点
{
	SListNode* res = (SListNode*)malloc(sizeof(SListNode));//申请一个节点空间
	res->data = x;//将x放入节点
	res->next = NULL;
	return res;//返回res
}
void SListPushFront(SListNode** pphead, SLTDataType x)//头插
{
	SListNode *tmp = BuySListNode(x);//给x申请一个新节点，并存入tmp
	tmp->next = *pphead;//让该节点的下一个节点为原链表的头节点
	*pphead = tmp;//让tmp变成新的头节点
}
void SListPopFront(SListNode** pphead)//头删
{
	if (*pphead = NULL)//如果该地址为空，则直接返回
	{
		return;
	}
	SListNode *tmp = (*pphead)->next;//创建一个结构体指针变量tmp，用来存储头节点的下一个节点
	free(*pphead);//释放头节点
	*pphead = tmp;//让tmp成为新的头节点
}
SListNode* SListFind(SListNode* phead, SLTDataType x) //寻找值为x的节点
{
	SListNode *tmp;
	for (tmp = phead; tmp; tmp->next)//遍历链表
	{
		if (tmp->data = x)//若存在与x相同的元素，则返回它
		{
			return tmp;
		}		
	}
	return NULL;
}
void SListInsertAfter(SListNode* pos, SLTDataType x)//在x后插入元素data
{
	SListNode *tmp = BuySListNode(x);//创建一个结构体指针，并为x申请一个节点，用tmp存储x的节点
	tmp->next = pos->next;//将pos的下一个节点赋给tmp的下一个节点
	pos->next = tmp;//将tmp赋给pos的下一个节点
}
void SListEraseAfter(SListNode* pos)//删除pos位置后一个的节点
{
	SListNode *tmp = pos->next;//创建一个结构体指针，将pos的下一个节点赋给tmp
	if (tmp==NULL)//如果为空，则直接返回
	{
		return;
	}
	pos->next = tmp->next;//将tmp的下一个节点赋给pos的下一个节点
	free(tmp);//释放tmp
}
void SListRemove(SListNode** pphead, SLTDataType x) //删除指定元素
{
	SListNode *tmp;
	if (*pphead == NULL)
	{
		return;
	}
	if ((*pphead)->data == x)//如果头节点就是x，那么直接删除它
	{
		SListPopFront(x);
		return;
	}
	for (tmp = *pphead; tmp; tmp->next)//遍历链表
	{
		if (tmp->next->data = x)//如果发现存在x则删除
		{
			SListEraseAfter(x);
			return;
		}
	}
}
void SListPrint(SListNode* phead)//打印链表
{
	SListNode* tmp;
	for (tmp = phead; tmp; tmp = tmp->next)
	{
		printf("%d->", tmp->data);
	}
	printf("NULL\n");
}
void SListDestory(SListNode** pphead) //销毁链表
{
	SListNode *tmp;
	if (*pphead == NULL)
	{
		return;
	}
	while ((*pphead)->next)//只要头节点下一个节点不为空，就不断删除
	{
		SListEraseAfter(*pphead);
	}
	free(*pphead);//释放头节点
	*pphead == NULL;
}

main.c
#include"list.h"
#include<windows.h>
int main()
{
	SListNode *phead;

	SListInit(&phead);

	SListPushFront(&phead, 1);
	SListPushFront(&phead, 2);
	SListPushFront(&phead, 3);
	SListPushFront(&phead, 4);
	SListPushFront(&phead, 5);
	SListPushFront(&phead, 6);
	SListPushFront(&phead, 7);
	SListPushFront(&phead, 8);
	SListPushFront(&phead, 9);
	//SListPopFront(&phead);
	//SListPopFront(&phead);
	/*
	SListInsertAfter(SListFind(phead, 6), 9);
	SListEraseAfter(SListFind(phead, 4));
	SListRemove(&phead, 7);
	SListPrint(phead);
	*/
	//SListRemoveAll(&phead, 8);
	SListReverse2(&phead);
	SListPrint(phead);


	SListDestory(&phead);

	//SListPrint(phead);
	system("pause");
	return 0;
}
