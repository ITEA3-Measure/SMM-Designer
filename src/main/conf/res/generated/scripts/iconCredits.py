from org.eclipse.swt.widgets import MessageBox
from org.eclipse.swt.widgets import Display
from org.eclipse.swt import SWT
    
m = MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_INFORMATION|SWT.OK)
m.setText("Credits")
m.setMessage(\
u"""This project reuses icons from the following designers:

Sergei Kokota - https://www.iconfinder.com/Zerg
Laura Reen - https://www.iconfinder.com/DemSt
Kirill Kazachek - https://www.iconfinder.com/kirill.kazachek
FatCow Web Hosting - http://www.fatcow.com/
Vecteezy - https://www.iconfinder.com/Vecteezy
The Pictographers - https://www.iconfinder.com/bluewolfski
Recep Kütük - https://www.iconfinder.com/recepkutuk
Alfredo - https://www.iconfinder.com/alfredoh
KOLOdesign - https://www.iconfinder.com/KOLOdesign
asad jawad eshtawe - https://www.iconfinder.com/ashrafweb
Last Call Media Inc - https://www.iconfinder.com/mrcolinp
Oxygen Team - http://www.oxygen-icons.org/
Maxim Basinski - https://www.iconfinder.com/vasabii
""")
m.open()
