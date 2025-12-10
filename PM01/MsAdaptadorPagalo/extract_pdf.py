import pypdf
import os

pdf_path = 'p_Microservicio MsAdaptadorPagalo V1.2.pdf'
output_path = 'pdf_content.txt'

try:
    reader = pypdf.PdfReader(pdf_path)
    text = ""
    for page in reader.pages:
        text += page.extract_text() + "\n"
    
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write(text)
    print(f"Successfully extracted text to {output_path}")
except Exception as e:
    print(f"Error extracting text: {e}")
