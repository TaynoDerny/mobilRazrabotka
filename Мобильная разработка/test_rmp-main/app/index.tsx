import Button from "@/components/Button/Button";
import Input from "@/components/Input/Input";
import TodoItem from "@/components/TodoItem/TodoItem";
import useTodos from "@/hooks/use-todos";
import { useState } from "react";
import { ScrollView, StyleSheet, Text, View } from "react-native";
// основной экран приложенйи
export default function Index() {
  const { todos, addTodo, deleteTodo, toggleTodo, clearCompleted } = useTodos();
  const [text, setText] = useState<string>("");

  return (
    // основной контейнер с возможностью прокрутки
    <ScrollView contentContainerStyle={styles.container }>// стиль контейнера
      <Text style={styles.title}>Мои задачи</Text> /// Заголовок

      <View style={styles.inputContainer}> // контейнер для ввода новой задачи
        // поле ввода т
        <Input 
          value={text} // текущее значение
          onChangeText={setText} // ОБработчик изменения 
          style={styles.input}// стиль для поля ввода 
        />
        
        <Button //кнопка для добавлние задач
          onPress={() => addTodo(text)}
        >
          <Text style={styles.text}>Add</Text>
        </Button>
      </View>
      
     <View> //контейнер для списка всех задач

        {todos.map(item => (
          <TodoItem 
            key={item.id} // Уникальынй ключ для каждый заддачи
            onDelete={() => deleteTodo(item.id)} //Функция удаления задачи
            onToggle={() => toggleTodo(item.id)} // Функция преключения выолнения задачи
            item={item}
          />
        ))}
      </View>

      <Button  //кнопка для удаления задач
        onPress={clearCompleted}
        type="danger"
      >
        <Text style={styles.btnDelete}>Delete all</Text>
      </Button>

    </ScrollView>
  )
}
/// Стили для контейнера
const styles = StyleSheet.create({
  title: {
    fontSize: 28,
    fontWeight: "700",
    marginBottom: 20,
  },
  container: {
    padding: 20,
  },
  text: {
    color: "#fff",
    fontSize: 16,
    fontWeight: "600",
  },
  inputContainer: {
    flexDirection: "row",
  },
  input: {
    flex: 1,
    marginRight: 16,
  },
  btnDelete: {
    color: "#fff",
  }
})