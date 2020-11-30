# Тестовое задание на Android разработку
Тут находится описание тестового задания для кандидатов на Android-разработку в команду KazanExpress.

## Задача
Нужно написать небольшое приложение с ресайклером и анимацей. Данные о статьях можно получить из
ArticlesRepository().loadArticles()

**Требования:**
* Нужно анимиривать bottom bar (при скролле вверх боттомбар должен плавно скрываться и появляться при обратном скролле)
* При клике на статью открывается новый фрагмент (отобразить контент и картинку), обязательно реализовать сохранение стейта на всех экранах (т.е. если свернуть приложение, убить его родительский процесс - оно восстановится на том же месте скролла как и было)
* ViewHolder для адаптера должен быть кастомной вью
* Иконки для боттом бара можно использовать любые стандартные