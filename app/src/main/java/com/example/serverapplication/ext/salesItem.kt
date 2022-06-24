package com.example.serverapplication.ext

import com.example.serverapplication.data.model.PaymentItem
import com.example.serverapplication.data.model.ProductItem
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.widget.common.TableTextViewInfo

fun SaleItem.toTableTextListItems(styleId: Int) = items.map { it.toTableText(styleId) }

fun ProductItem.toTableText(styleId: Int) = TableTextViewInfo(
    firstTitle = name,
    secondTitle = quantity.toString(),
    thirdTitle = amount.toString(),
    firstStyleId = styleId,
    secondStyleId = styleId,
    thirdStyleId = styleId
)

fun SaleItem.toTableTextListPayed(styleId: Int) = payments.map { it.toTableText(styleId) }

fun PaymentItem.toTableText(styleId: Int) = listOf(
    TableTextViewInfo(
        firstTitle = "Cash",
        thirdTitle = amount.toString(),
        firstStyleId = styleId,
        thirdStyleId = styleId
    ),
    TableTextViewInfo(
        firstTitle = "Change",
        thirdTitle = change.toString(),
        firstStyleId = styleId,
        thirdStyleId = styleId
    )
)