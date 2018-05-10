package com.galukhin.learningandroid.___ui;

/* чтобы использовать в java коде у вью должен быть android:id
 * договоренность @+id/... для первого упоминания, а при следующих без +
 *      - помогает избежать опечаток: если нет + для виджета и при этом он еше не встречался,
 *      компилятор сообщит
 *
 * чтобы использовать в коде нужен вызов findViewById() + плюс числовое йиди из R.id.smth
 * */



/* button is subclass of textview*/


/* margin пространстов между виджетом и его окружением
 * можно ставить для всех строн или для одной напр layout_marginTop
 * с андроид8+ еще есть для устрановки маржина для 2 сторон на 1 оси*/

/* padding пространство между содержание виджета и его рамкой. напр кнопка
 * - можно ставитиь для всех сторон одновременно padding либо для одной, напр. paddingLeft
 * или stePadding() в коде
 * с андроид8+ еще есть paddingVertical и horizontal для устрановки падинга с 2 сторон на 1 оси
 * */

/* разница между паддингом и маржином может быть не заметна при прозрачном фоне*/

/* есть 2 типа цветов:
 * 1- напр. background принимает цвет или картинку
 * 2 -напр textColor принимает ColorStateList через setter метод
 *   - разные цвета для разных условий
 *   - ColorStateList.valueOf() - вернет лист цветов, но с 1 цветом - эквивалент атрибута textColor
 *   т.е. 1 цвет вне зависимости от условий
 *       - или можно создать свой через конструктор или xml drawable
 * */

/* visibility - контролирует изначальную видимость виджета */

/* nextFocusDown, nextFocusLeft, nextFocusRight, nextFocusUp - контролирует порядок фокуса если юзер
 * использует D-pad, trackball и скожий девайс-указатель */


/*Полезные методы
 * - setEnabled(), isEnabled() - установка и проверка включенности виджета
 *    - напр. отключить какие-то виджеты на основании установки чекбокса или радиобатона
 *
 * - requestFocus(), isFocused - предоставить и проверить фокус для виджета
 *      - напр. после отключения какого-то виджета установить фокус на другой
 *
 * - навигация:
 *  - getParent() найти родительский виджет или контейнер
 *  - findViewById() найти ребенка-виджета по конкретному ID
 *  - getRootView() получить корень дерева
 *      - напр. то, что было указазано для активити через setContentView()
 * */


/* Layout managers (containers)
* бейслайн - условная линия на которой находится текст
*
* - LinearLayout
*   - содержимое (виджеты или внутренние контейнеры) представлено 1 за другим либо в ряд либо в колону
*   4 главные зоны контроля, кроме контента контейнера:
*       - orientation (можно менять в рантайме setOrientation())
*           - ряд (horizontal)
*           - колона (vertical)
*
*       - модель заполнения
*           - при заполнении места побеждает старший сын:
*               - напр. LinearLayout c 3 детьми, первый получит запрашиваемое место, второй - если
*               еще есть и т.д.
*                   - т.е. если первый запросит все место, то следующим его не достанется
*
*       - вес (weight)
*           - разделить по пропорции место среди нескольких элементов
*               - если у них одинаковая пропорция - разделятся поровну
*               - если у одного 1, а у другого 2 - второму в 2 раза больше места достанется
*               - по дефолту вес 0
*               - можно использовать как процент:
*                   - установить всем элементам layout_width 0
*                   - установить кому нужно layout_weight в нужный процент
*                   - сумма должна быть 100
*               - если нужно, чтоб осталось место без виджетов, нужно добавить weightSum в LinearLayout
*               и удостоверится, что сумма всех layout_weight меньше этой суммы, т.е. разделение
*               происходит отталкиваясь от этой суммы
*
*       - гравитация
*           - то, откуда начинаются элементы (start + top)
*           - у А есть 2 типа гравитации:
*               - гравитация виджета в LinLay
*                   layout_gravity
*                       - работает только в сторону, противоположную ориентации контейнера
*                           - т.е. в вертикальной ориентации позицию layout_gravity можно указывать
*                           только горизонтально
*               - гравитация контента виджета или контейнера
*                   gravity
*
*
*                   When this gets rendered on the screen, LinearLayout will make two passes through
its children. On the first pass, it asks for how much space each child wants, based
upon the android:layout_height values (since this is a vertical LinearLayout).
The first Button will ask for 0 pixels of space, while the bottom Button will ask for
however much it needs for its content. Then, the second pass of the LinearLayout
through its children asks for their weights. The first Button has a weight of 1, while
the bottom Button has the default weight of 0. As a result, the top Button gets 1/1 = 100% of all pixels left over from what the first pass used. This causes the top Button
to become tall, shoving the bottom Button to the bottom of the screen.
*
*
* - RelativeLayout
*   - можно указывать расположение относительно других элементов или родительского:
*       - родительского: layout_alignParentTop, layout_alignParentBottom, layout_alignParentStart,
*       layout_alignParentEnd, layout_centerHorizontal, layout_centerVertical, layout_centerInParent
*       - других (нужно указать их id): layout_above, layout_below, layout_toStartOf, layout_toEndOf
*           - также есть 5 дополнительных для выравнивания по референсу: layout_alignTop,
*           layout_alignBottom, layout_alignStart, layout_alignEnd, layout_alignBaseLine
*   - позволяет 1 элементу перекрывать другой (в отличие от линиарлейаута - хотя с 5.0 там появлился
*   похожий атрибут elevation)
*       - последний перекрывает более старый
*
*
* - TableLayout
*   - позволяет размещать виджеты в сетке
*   - отлично подходит для форм
*   - можно контролировать кол-во рядов и колонок, какие из них будут расширятся или сужаться по
*   содержанию
*   - работает в кооперации с TableRow: TableLayout контролирует общее поведение контейнера, а сами
*   виджеты помещены в 1 или более контейнеры TableRow - 1 на ряд в сетке
*       - т.е. я задаю кол-во рядов,
*       - а кол-во колонок контролируется андроидом
*           - по самому длиному ряду
*   - виджет может занимать больше 1 колонки - layout_span
*   - счет колонок начинается с 0, и по дефолту виджет помещается в 0, но можно указать вручную:
*   layout_column
*   - можно также помещать виджеты между колон - тогда TableLayout ведет себя немного как LinearLayout с
*   вертикальной ориентацией
*       - у виджета автоматически установлена match_parent - они займут столько ширины, сколько самый
*       широкий ряд
*   - по дефолту ширина колонки - по самому широкому контенту (с учетом расспаненных колонок)
*       - ширину можно устанавливать для нужных колонок атрибутами stretchColumns (указывается куда
*       пойдет все свободное оставшееся место)/shrinkColumns
*       контейнера (в рантайме setColumnStrechable(), setColumnShrinkable())
*   - еще есть атрибут collapseColumns - колонки изначально будут невидимы, а потом их можно программно
*   активировать (setColumnCollapsed())
*       - напр. пользователь сам решает, какие колонки ему важны
*
*
* - RadioGroup - LinearLayout для радиобаттонов
*           - взаимоисключение применяется только к элементам
*               - не должно быть других контейнеров между RadioGroup и его радиобаттон виджетами
*           - check() - отметить радиобаттон по айди
*           - clearCheck() - очистить все
*           - getCheckedRadioButtonId - узнать отмеченный
*
* - ScrollView/HorizontalScrollView (вертикальный/горизонтальный)
*   - поместить внутрь другой контейнер и он станет скрольным
*   - может иметь только 1 элемент внутри
*   - внутри не может быть других скролов
*   - ListView сам знает как скролится
*
* - ConstraintLayout
*   - подключается отдельной библой (~ 100 кб) через депенденси
*   - RelativeLayout плохо понимал намерения дева при работе с GUI designer
*   - рассчитан на улучшение перформанса (при работе с Gui designer?)
*   - похож на Relative - можно привязывать виджеты к другим или к границам самого контейнера
*       - напр. app:layout_constraintBottom_toTopOf="..."
*           - значит привязать низ к верху указанного виджета или parent
*   - много чего от Linear - размещение виджетов на основании веса (без двойного прохода по детям
*   для определения этих размеров)
*   - Guideline виджеты (прямая вертикальная или горизонтальная линия)
*       - помогают привязывать внутри контейнера но не к контейнеру или другим виджетам
*           - как некоторое правило, по которому например выравниваются элементы
*       - не рендерятся в UI
*       - помогают работать как с процентами в линеар лейауте
*           - layout_constraintGuide_percent
*           - при этом не надо 2 раза проходить
*   - можно конвертировать существующие лейауты в констрейнт Convert .. toConstraintLayout
*
* - FrameLayout
*       - используется редко
*           - обычно, когда нужно зарезервировать место для чего-то пока неизвестного при компиляции
*               - напр. фрагмент
*           - или когда нужна рамка вокруг элемента в контейнере
*       - 2 простых правила работы:
*           - все дети идут в верхний начальный угол
*               - если gravity не указывает другое
*           - последний ребенок выше по оси Z предыдущих
*
*
*
* - GridLayout
*
* left/right были заменены на start/end с API Level17 с улучшенной поддержки RTL (right to left)
* */

/* layout_ префикс для правил, основанных на контейнере виджета */


/* 2 state widgets
 * checkbox
 * toggle button
 * switch (с апи 14)
 * radio button
 *
 * - наследуются от CompoundButton, который наследуется от TextView
 * - можно повешать OnCheckedChangeListener
 * - можно менять, узнавать и тоглить состояние
 * */

/* прогрессбар
 * - устанавливается интом
 * - диапазон значений можно установить
 *   - c 8.0 есть минимальное значение setMin()
 * - начальная позиция 0, но можно и установить setProgress()
 * - setIndeterminate() - просто анимация без точного указания прогресса
 * - прогресс устанавливается либо через setProgress() либо incrementProgressBy()
 * */

/* виджет или коллекцию виджетов можно переиспользовать в нескольких XML ресурсах
 *  - нужно создать такой xml ресурс а потом добавлять с помощью <include>:
 *       <include layout="@layout/thing">
 *       - можно даже ассайнить высоту и ширину элементу, который переиспользуется
 *       - refactor - extract layout - из выделенных сделать отдельный лейаут
 *          - если элементы не объеденены в свой контейнер, а студио обернет их в xml элемент <merge>
 *              - т.к. не может быть нескольких коренных элементов в 1 xml файле
 *
 *           */


/*selection widgets
 * - ListView
 *
 * - Spinner
 *   - дроп-даун
 *   - setDropDownViewResource() - установить вью для исопльзования
 *   - поддерживают только выбор
 *
 * - GridView
 *   - 2-мерный список
 *   - слабый контроль над кол-вом и размером колонок
 *   - кол-во рядов определяется динамически
 *   - атрибуты:
 *      - numColumns - кол-во колонок, можно auto_fit
 *      - verticalSpacing и horizontalSpacing пространство между элементами в сетке
 *      - columnWidth - ширина колонки
 *      - stretchMode, если установлен auto_fit, определяет что должно произойти для любого свободного
 *      места не занятого колонками или спейсингом
 *   - поддерживают и выбор и клики
 *
 * - ExpandableListView
 *   - ограниченное дерево - поддерживает 2-уравневую иерархию
 *
 * - и т.д.
 *
 * - общий суперкласс AdapterView
 *   - так называется потому что они взаимодейтсвуют с объектами, которые имплементят интерфейс
 *   Adapter для определения доступного юзеру выбора
 * */


/* Adapter
 * - адаптер мост между моделью данных и их визуальным представлением в AdapterView
 *           - адаптер может адаптировать Invoice в View, который будет служить рядом в ListView
 *           - адаптер может адаптировать Book в View, который будет служить ячейкой в GridView
 *           - и т.д.
 *           - разные адаптеры для разных источников
 *               - напр. для коллекций или для баз данных
 *           - есть базовый BaseAdapter если нужно сделать свой, когда нет подходящего для моей
 *           коллекции
 *
 * - ArrayAdapter
 *  - работает от массива или списка
 *  - на вход принимает:
 *      - контекст
 *      - айди ресурса View, который нужно исопльзовать (есть встроенные в систему)
 *      - сам массив\список
 *  - по дефолту вызывает toString() для объектов списка и оборачивает строки в указанный View
 *  - знает только как работает 1 TextView, поэтому для более сложных вью нужно расширять
 *      - переопределить конструктор и getView()
 *      - ViewHolder pattern
 *          - у всех View есть методы setTag() и getTag() - можно ассоциировать любой объект с виджетом
 *          - паттерн удерживает объект: при аттаче холдера к ряду View, при каждом использовании ряда
 *          у нас есть доступ ко всем виджетам-детям, без необходимости вызывать дорогостоющую операцию
 *          findViewById() каждый раз
 *
 *  - setOnItemSelectedListener() - нажатие по элементу
 *
 *  - ListActivity - список на весь экран
 *      - getListView() получить список от активности
 *
 * - setChoiceMode() (или атрибутом) для ListView: CHOICE_MODE_SINGLE и CHOICE_MODE_MULTIPLE
 *      - режим выбора кол-ва элементов
 *          - есть вьюхи simple_list_item_multiple_choice (это с галочками)
 *      - getCheckedItemPositions(), setItemChecked()
 * */

/* AutoCompleteTextView
 * - гибрид EditText и Spinner
 * - вводимый текст оценивается по префикс-фильтру и подходящие варианты показываются в спинере
 * - подкласс EditText
 * - completionThreshold - сколько пользователь должен ввести символв перед началом фильтеринга
 * - setAdapter() добавить адаптер
 * - зарегать TextWatcher для отслеживания изменений текста или при выборе из спинера
 *   - onTextChanged(), beforeTextChanged(), afterTextChanged()
 * - как и EditText поддрежвает подсветку ошибок правописания
 * */

/*Widgets based on the “spinner” paradigm
— including Spinner — treat everything as selection events. Other widgets — like
ListView and GridView — treat selection events and click events differently. For
these widgets, selection events are driven by the pointing device, such as using
arrow keys to move a highlight bar up and down a list. Click events are when the
user either “clicks” the pointing device (e.g., presses the center D-pad button) or
taps on something in the widget using the touchscreen.

If the user clicks a row in a ListView, a click event is registered, triggering things
like onListItemClick() in an OnItemClickListener. If the user uses a pointing
device to change a selection (e.g., pressing up and down arrows to move a highlight
bar in the ListView), that triggers onItemSelected() in an
OnItemSelectedListener.

Many times, particularly if the ListView is the entire UI at present, you only care
about clicks. Sometimes, particularly if the ListView is adjacent to something else
(e.g., on a TV, where you have more screen space and do not have a touchscreen),
you will care more about selection events.
*/

/*webview
 * - для простых html есть утилитный класс Html и статический метод fromHtml() для парсинга html-форматированной
 * строки
 * - webview может справляться с большим кол-во html тегов, а также с css и javascript
 * -произошел от веб рендерингового движка от Chrome
 * - c 5.0 webview больше не часть андроида, а отдельный апп независимый от firmware, чтобы быстрее
 * фиксить проблемы
 *- для 7.0 имплементация берется из 1 из 2 мест:
 *   - браузера Chrome
 *   - системного аппа WebView, если на устройстве задисейблин хром
 *- сам знает как скролить свой контент
 * - loadUrl() загрузка нужного урла, работает с
 *       - http://, https://
 *       - file://
 *       - file://android_asset/
 *       - content:// урл контент провайдера
 * - loadData():
 *   - для локального файла
 *   - для кусочка html
 *   - можно даже сгенерить интерфейс полностью на html вместо виджетов
 *   - нужно предоставить контент, майм тайп (обычно text/html) и кодировку - все строками
 *   - иногда при проблемах стоит использовать loadDataWithBaseUrl() с пустым базовым урлом по неясным причинам
 *
 * - для интернета нужен пермишн
 * - на девайсах без системного аппа (до 4.4 включительно) при клике на линку может открываться браузер
 * - по дефолту js отключен, включить:
 *       - webView.getSettings().setJavaScriptEnabled(true)
 * */


/*Style
 * - предназначение стиля - инкапсулировать набор аттрибутов, которые я буду часто использовать
 *  - т.е. DRY
 * - у виджетов есть атрибут style (без android: вначале
 * - находятся в values в файле (по договоренности) styles.xml
 * - где применяется стиль:
 *      - к виджету
 *      - к контейнеру
 *          - но к его элементам не аплаится
 *      - к активности или приложению в целом
 *          - это уже называется темой
 *
 * - какие атрибуты можно определять в стиле:
 *      - любые для данного виджета\контейнера
 *      - а также контейнерские типа layout_width
 *      - не подходящие игнорируются
 *
 *
 * - как наследоваться от существующего:
 *      - указывается так <style name="child" parent="android.Theme.Halo">
 *
 * - какие значения могут иметь атрибуты в определениях стиля:
 *      - обычно константные значения
 *      - но можно сослаться и на значение атрибута родителя
 *          <item name="android:background">?android:attr/activatedBackgroundIndicator</item>
 *
 * */

/* Theme
 * - это стиль примененный к активности или апу через атрибут android:theme
 *   - т.е. фокус здесь больше не на отдельных виджетах
 * - если тема моя, то ссылаться так же как и на стиль: @style/...
 * - если тема не моя, то надо так: @android:style/Theme.Holo.Light
 * - если темы нет, то все зависит от версии андроида:
 *   - на 1 и 2 темой является Theme
 *   - на 3 и 4 при minSdKVersion или targetSdkVersion >= 11 - Theme.Halo, иначе просто Theme
 *   - на 5 и выше если targetSdkVersion >= 14 - Theme.Material, иначе Theme.Halo
 *   - т.е. напр. версия 2.0 ничего не знает о Theme.Material и не будет отображаться там
 *       - выход - для разных версий апи указать разные ресурсы
 *
 * */


/*Использование виджетов и контейнеров из библиотек
 * - при использовании их из сдк:
 *   - префикс android: для почти всех атрибутов
 *   - имя класса (напр. Button) вместо полного квалификатора имени класса (android.widget.Button)
 *   для почти всех имен элементов
 *
 * - при использовании из библы:
 *   - для атрибутов используется сочетание префиксов android: и app: (для тех, что не часть сдк)
 *       - для прификса апп нужно новое пространство имен xml:
 *           xmlns:app="http://schemas.android.com/apk/res-auto"
 *   - полное имя квалификатора
 *
 * */


/*actionbar
 * - 1.x/2.x
 *  - были status bar (с часами) и title bar(у самого аппа сверху - просто название апа)
 *
 * - 3.x/4.1, таблетс
 *      - статус бар стал систем бар, помещался снизу и там добавились кнопки бек, хом и т.д (на пред
 *      ыдущих девайсах требовались апаратные кнопки)
 *      - вместо тайтл бара экшн бар и можно определять, что будет там (иконки, название, кнопки тулбара и т.д)
 *          - иконка слева тоже может быть тулбарной кнопкой (обычно для мейн или хоум активити)
 *      - иногда 3 точки - action overflow или overflow menu
 *          - показывает действия недоступные из-за малого экрана
 *          - маловажные действия сворачиваются в любом случае
 *
 * - 4.0 - 4.4, телефоны
 *      - телефоны в версии 3.0 не поддерживались, и перешли с 2.3 сразу в 4.0
 *      - получили некоторые фичи с 3.0
 *          - могли иметь экшн бар как у таблетсов
 *          - кнопки хоум и бек могли быть также опущены производителями девайсов
 *          - статус бар остался как в 2.х
 *
 * - 4.2 - 4.4, таблетс
 *      - статус бар сверху
 *      - экшн бар под статус баром
 *      - систем бар снизу с кнопками навигации
 *
 * - 5.0
 *      - экшн бар функционально такой же, но убрали иконку (типа противоречит материал дизайну)
 *          - но можно на экшн баре вызвать setDisplayShowHomeEnabled(true) и покажет иконку из
 *          манифеста или поставить другую через setIcon()
 *
 *
 *
 * - c 3.0 экшн бар поддерживается на уровне firmware через sdk
 *      - есть класс ActionBar
 *      - получить экземпляр для активити можено через getActionBar()
 *      - для апи ниже 11 можно:
 *          - использовать апи "menu"
 *          - использовать appcompat-v7
 *
 *
 * - добавить экшены в оверфлоу:
 *      - при помощи меню ресурса (res/menu)
 *          - для каждого айтема:
 *              - его айди (чтобы знать, на что нажал юзер)
 *              - тайтл (текст) для айтема
 *              - иконка
 *              - флаг как показывать этот айтем: всегда, если есть место и т.д.
 *                  - можно также указать, чтобы иконка была и с текстом, если отображается на экшн баре
 *      - в меню эдиторе андроид студио
 *      - потом оверрайд onCreateOptionsMenu() и MenuInflater должен накачать ресурс и вставить в
 *      объект меню
 *          - потом оверрайд onOptionsItemSelected() - с кейсами для всех экшенов
 *              - если я хендлю ивент, то нужно вернуть тру
 *      - android.R.id.home - это иконка аппа в экшн баре
 *          - с 14 нужно также вызывать setHomeButtonEnabled(true) для экшн бара
 *          - иконки может не быть если используется Theme.Material на 5.0+
 *
 * - с 4.4 ... стали обязательны независимо от того, есть ли кнопка меню на девайсе, чтобы убрать
 * путаницу
 *
 * */

/*тосты
* - не забирает фокус с активности (если юзер тайпает что-то)
* - makeText(), нужен активити или другой контекс и продолжительность
*   - потом show()
* */


/*vector drawable
* - c 5.0 нативная поддержка
* - есть Vector Asset wizard
*       - для старых версий (ниже 21) автоматически преобразует в PNG
* - 2 источника vector drawable рисунков:
*    - xml файлы уже в vector drawable xml формате
*    - svg файлы, которые нужно перевести в vector drawable xml формат
*        - градиенты, патерны и тексты не поддерживается
*
* - используются чаше всего для иконок на верхней панели
*
* - чтобы использовать сгенеринные пнг для старых апи нужно в билд гредл указать для каких разрешений
* генерить:
*       vectorDrawables.generatedDensities = ['hdpi', 'xxhdpi']
*
* - но уже есть либа support-vector-drawable по апи 7
*
*
* */

public class Main {
}