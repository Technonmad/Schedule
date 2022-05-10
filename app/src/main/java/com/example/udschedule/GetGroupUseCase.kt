package com.example.udschedule

class GetGroupUseCase(private val groupRepository: GroupRepository) {

    fun execute(): GroupModel{
        return GroupModel(groupName = "Сюды запихнуть запрос из бд")
    }

}