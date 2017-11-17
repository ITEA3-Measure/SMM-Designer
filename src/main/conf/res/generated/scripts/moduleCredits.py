from org.eclipse.swt.widgets import MessageBox
from org.eclipse.swt.widgets import Display
from org.eclipse.swt import SWT
    
m = MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_INFORMATION|SWT.OK)
m.setText("Credits")
m.setMessage(\
u"""This Moadule has bean devlopend by Softeam in context of  Measure Project

""")
m.open()
