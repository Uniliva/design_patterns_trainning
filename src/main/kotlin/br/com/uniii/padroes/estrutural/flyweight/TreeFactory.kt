package br.com.uniii.padroes.estrutural.flyweight

import java.awt.Color


object TreeFactory {
    var treeTypes: MutableMap<String, TreeType> = HashMap()

    fun getTreeType(name: String, color: Color, otherTreeData: String?): TreeType {
        var result = treeTypes[name]
        if (result == null) {
            result = TreeType(name, color, otherTreeData!!)
            treeTypes[name] = result
        }
        return result
    }
}